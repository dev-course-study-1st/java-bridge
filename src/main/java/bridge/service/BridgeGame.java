package bridge.service;

import bridge.BridgeMaker;
import bridge.domain.Bridge;
import bridge.domain.BridgeMap;
import bridge.domain.GameResult;
import bridge.domain.GameStatus;
import bridge.domain.MovingCommand;
import bridge.domain.RoundStatus;
import java.util.List;

public class BridgeGame {

    private final BridgeMap bridgeMap;
    private final BridgeMaker bridgeMaker;
    private final GameStatus gameStatus;
    private Bridge bridge;

    public BridgeGame(BridgeMap bridgeMap, BridgeMaker bridgeMaker, GameStatus gameStatus) {
        this.gameStatus = gameStatus;
        this.bridgeMap = bridgeMap;
        this.bridgeMaker = bridgeMaker;
    }

    public void makeBridge(int value) {
        List<String> bridgeFrom = bridgeMaker.makeBridge(value);
        bridge = new Bridge(bridgeFrom);
    }

    public BridgeMap move(int index, MovingCommand movingCommand) {
        RoundStatus roundStatus = getRoundStates(index, movingCommand, bridge);
        bridgeMap.updateMap(movingCommand, roundStatus);
        return bridgeMap;
    }

    private static RoundStatus getRoundStates(int index, MovingCommand movingCommand, Bridge bridge) {
        if (bridge.canGo(index, movingCommand)) {
            return RoundStatus.ROUND_CONTINUE;
        }
        return RoundStatus.ROUND_END;
    }

    public void retry() {
        gameStatus.addTryCount();
        bridgeMap.reset();
    }

    public int getBridgeSize() {
        return bridge.getSize();
    }

    public boolean isRoundEnd(int i, MovingCommand movingCommand) {
        return !bridge.canGo(i, movingCommand);
    }

    public GameResult getResult() {
        return new GameResult(gameStatus.getTryCount(), gameStatus.isSuccess(), bridgeMap);
    }

    public void setIsSuccessInGame() {
        gameStatus.success();
    }
}
