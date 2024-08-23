package bridge.service;

import bridge.model.*;
import bridge.utils.enums.RestartCommend;

import java.util.List;

import static bridge.utils.enums.Const.ATTEMPT_INIT_NUMBER;

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

    public BridgeState move(String moveCommend) {
        MoveResult moveResult = bridgeGame.move(moveCommend);
        bridgeState.addMoveResult(moveResult);
        return bridgeState;
    }

    public boolean retry(String gameCommend) {
        if (RestartCommend.RESTART.isEqualTo(gameCommend)) {
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
        return isGameComplete() && bridgeState.isSuccess();
    }

    private boolean isGameComplete() {
        return bridgeGame.isGameComplete();
    }

}
