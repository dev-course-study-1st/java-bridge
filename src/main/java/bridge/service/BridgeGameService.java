package bridge.service;

import bridge.model.*;
import bridge.utils.enums.RestartCommand;

public class BridgeGameService {
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;
    private BridgeState bridgeState;

    public BridgeGameService(BridgeMaker bridgeMaker, BridgeState bridgeState) {
        this.bridgeMaker = bridgeMaker;
        this.bridgeState = bridgeState;
    }

    public void initializeGame(BridgeSize bridgeSize) {
        this.bridgeGame = new BridgeGame(bridgeSize, bridgeMaker);
    }

    public BridgeState move(String moveCommand) {
        MoveResult moveResult = bridgeGame.move(moveCommand);
        bridgeState.addMoveResult(moveResult);
        return bridgeState;
    }

    public boolean retry(String gameCommand) {
        if (RestartCommand.RESTART.isEqualTo(gameCommand)) {
            bridgeGame.retry();
            bridgeState.clear();
            return true;
        }
        return false;
    }

    public boolean isGameSuccess(){
        return bridgeState.isSuccess();
    }

    public boolean isGameWon() {
        return isGameComplete() && isGameSuccess();
    }

    private boolean isGameComplete() {
        return bridgeGame.isGameComplete();
    }

}
