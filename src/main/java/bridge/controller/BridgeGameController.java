package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final OutputView outputView;
    private final InputView inputView;
    private BridgeGame bridgeGame;

    public BridgeGameController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void play() {
        outputView.initGame();
        Bridge bridge = initBridge();
        bridgeGame = new BridgeGame(bridge);
        while (bridgeGame.isRunning()) {
            playOneRound(bridge);
        }
        outputView.printResult(bridgeGame.isGameSuccess(), bridgeGame.getTryCount());
    }


    private void playOneRound(Bridge bridge) {
        checkMove(bridge);
        bridgeGame.isGameEnd();
        if (bridgeGame.isGameSuccess()) {
            return;
        }
        playOneRound(bridge);
    }


    private void checkMove(Bridge bridge) {
        inputMoving();
        outputView.printMap(bridgeGame.getUserBridge().getUserBridge(), bridge.getBridge());
        if (!bridgeGame.isRunning()) {
            retry();
        }
    }

    private Bridge initBridge() {
        try {
            int bridgeSize = inputView.readBridgeSize();
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            return new Bridge(bridgeMaker.makeBridge(bridgeSize));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return initBridge();
        }
    }

    private void inputMoving() {
        try {
            String moveCommand = inputView.readMoving();
            bridgeGame.move(moveCommand);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            inputMoving();
        }
    }

    private void retry() {
        try {
            String gameCommand = inputView.readGameCommand();
            bridgeGame.retry(gameCommand);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            retry();
        }
    }

}
