package bridge.controller;

import bridge.model.BridgeSize;
import bridge.model.MoveResult;
import bridge.service.BridgeGame;
import bridge.utils.handler.InputHandler;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final BridgeGame bridgeGame;
    private int attemptCount;

    public BridgeGameController(BridgeGame bridgeGame,int attemptCount) {
        this.bridgeGame = bridgeGame;
        this.attemptCount = attemptCount;
    }

    public void run(){
        OutputView.printGameStart();
        BridgeSize bridgeSize = InputHandler.handleInput(InputView::readBridgeSize);
        while (true){
            String moveCommend = InputHandler.handleInput(InputView::readMoving);
            MoveResult result = bridgeGame.move(moveCommend);
        }

    }
}
