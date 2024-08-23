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

    // TODO : Refactoring 진행하기 ident가 3 이하로 줄이기
    public void play() {
        outputView.initGame();
        Bridge bridge = initBridge();
        bridgeGame = new BridgeGame(bridge);
        while (true) {
            boolean isMove = inputMoving();
            outputView.printMap(bridgeGame.getUserBridge().getUserBridge(), bridge.getBridge());
            if (!isMove) {
                if (!retry()) {
                    outputView.printResult(false, bridgeGame.getTryCount());
                    break;
                }
            }
            boolean isGameEnd = bridgeGame.isGameEnd();
            if (isGameEnd) {
                outputView.printResult(true, bridgeGame.getTryCount());
                break;
            }
        }
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
