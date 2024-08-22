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

    public void play() {
        outputView.initGame();
        Bridge bridge = initBridge();
        bridgeGame = new BridgeGame(bridge);
        while(true) {
            boolean isMove = inputMoving();
            outputView.printMap(bridgeGame.getUserBridge(),bridge.getBridge());
            if(!isMove) {
                if(!retry()) {
                    outputView.printResult(false,bridgeGame.getTryCount());
                    break;
                }
            }
            boolean isGameEnd = bridgeGame.isGameEnd();
            if(isGameEnd) {
                outputView.printResult(true,bridgeGame.getTryCount());
                break;
            }
        }
    }

    private Bridge initBridge() {
        int bridgeSize = inputView.readBridgeSize();
        return new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize));
    }

    private boolean inputMoving() {
        String moveCommand = inputView.readMoving();
        return bridgeGame.move(moveCommand);
    }

    private boolean retry() {
        String gameCommand = inputView.readGameCommand();
        return bridgeGame.retry(gameCommand);
    }
}
