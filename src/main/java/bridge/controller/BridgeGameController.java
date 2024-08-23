package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private BridgeGame bridgeGame;
    private boolean isGameEndStatus = false;
    private boolean isGameRunning = false;

    public void play() {
        outputView.initGame();
        Bridge bridge = initBridge();
        bridgeGame = new BridgeGame(bridge);
        while (!isGameRunning) {
            playOneRound(bridge);
        }
        outputView.printResult(isGameEndStatus, bridgeGame.getTryCount());
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

    private void playOneRound(Bridge bridge) {
        if (!checkMove(bridge)) {
            return;
        }
        if (checkGameEnd()) {
            return;
        }
        playOneRound(bridge);
    }

    private boolean checkMove(Bridge bridge) {
        boolean isMove = inputMoving();
        outputView.printMap(bridgeGame.getUserBridge().getUserBridge(), bridge.getBridge());
        if (!isMove) {
            if (!retry()) {
                isGameEndStatus = false;
                isGameRunning = true;
                return false;
            }
        }
        return true;
    }

    private boolean checkGameEnd() {
        boolean isGameEnd = bridgeGame.isGameEnd();
        if (isGameEnd) {
            isGameRunning = true;
            return true;
        }
        return false;
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
