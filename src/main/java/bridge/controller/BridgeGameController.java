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
    private boolean isGameEndStatus = false;
    private boolean isGameRunning = false;

    public BridgeGameController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void play() {
        outputView.initGame();
        Bridge bridge = initBridge();
        bridgeGame = new BridgeGame(bridge);
        while (!isGameRunning) {
            playOneRound(bridge);
        }
        outputView.printResult(isGameEndStatus, bridgeGame.getTryCount());
    }

    private void playOneRound(Bridge bridge) {
        checkMove(bridge);
        isGameEndStatus = bridgeGame.isGameEnd();
        if (isGameEndStatus) {
            return;
        }
        playOneRound(bridge);
    }

    private void checkMove(Bridge bridge) {
        boolean isMove = inputMoving();
        outputView.printMap(bridgeGame.getUserBridge().getUserBridge(), bridge.getBridge());
        if (!isMove) {
            if (!retry()) {
                isGameEndStatus = false;
                isGameRunning = false;
                return;
            }
        }
        isGameRunning = true;
    }

    private Bridge initBridge() {
        try {
            int bridgeSize = inputView.readBridgeSize();
            return new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return initBridge();
        }
    }

    private boolean inputMoving() {
        try {
            String moveCommand = inputView.readMoving();
            return bridgeGame.move(moveCommand);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputMoving();
        }
    }

    private boolean retry() {
        try {
            String gameCommand = inputView.readGameCommand();
            return bridgeGame.retry(gameCommand);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return retry();
        }
    }

}
