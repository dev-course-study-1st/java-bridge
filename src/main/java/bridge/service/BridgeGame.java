package bridge.service;

import bridge.BridgeMaker;
import bridge.domain.Bridge;
import bridge.domain.BridgeMap;
import bridge.domain.GameResult;
import bridge.domain.MovingCommand;
import bridge.domain.RoundStatus;
import bridge.repository.GameRepository;
import java.util.List;

public class BridgeGame {

    private final GameRepository gameRepository;
    private final BridgeMap bridgeMap;
    private final BridgeMaker bridgeMaker;

    public BridgeGame(GameRepository gameRepository, BridgeMap bridgeMap, BridgeMaker bridgeMaker) {
        this.gameRepository = gameRepository;
        this.bridgeMap = bridgeMap;
        this.bridgeMaker = bridgeMaker;
    }

    public void makeBridge(int value) {
        List<String> strings = bridgeMaker.makeBridge(value);
        Bridge bridge = new Bridge(strings);
        gameRepository.save(bridge);
    }

    public BridgeMap move(int index, MovingCommand movingCommand) {
        Bridge bridge = gameRepository.getBridge();
        RoundStatus roundStatus = getRoundStates(index, movingCommand, bridge);
        bridgeMap.updateMap(movingCommand, roundStatus);
        return bridgeMap;
    }

    private static RoundStatus getRoundStates(int index, MovingCommand movingCommand, Bridge bridge) {
        if (bridge.canGo(index, movingCommand.getValue())) {
            return RoundStatus.ROUND_CONTINUE;
        }
        return RoundStatus.ROUND_END;
    }

    public void retry() {
        gameRepository.addAttempts();
        bridgeMap.reset();
    }

    public int getBridgeSize() {
        return gameRepository.getSize();
    }

    public boolean isRoundEnd(int i, MovingCommand movingCommand) {
        return !gameRepository.isGo(i, movingCommand);
    }

    public GameResult getResult() {
        return new GameResult(gameRepository.getAttempts(), gameRepository.getIsSuccessInGame(), bridgeMap);
    }

    public void setIsSuccessInGame() {
        gameRepository.setIsSuccessInGame();
    }
}
