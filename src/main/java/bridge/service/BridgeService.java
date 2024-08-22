package bridge.service;

import bridge.BridgeMaker;
import bridge.domain.ApplicationStatus;
import bridge.domain.Bridge;
import bridge.domain.BridgeMap;
import bridge.domain.BridgeSize;
import bridge.domain.GameResult;
import bridge.domain.MovingCommand;
import bridge.domain.RoundStatus;
import bridge.repository.GameRepository;
import java.util.List;

public class BridgeService {

    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;
    private final GameRepository gameRepository;

    public BridgeService(BridgeMaker bridgeMaker, BridgeGame bridgeGame, GameRepository gameRepository) {
        this.bridgeMaker = bridgeMaker;
        this.bridgeGame = bridgeGame;
        this.gameRepository = gameRepository;
    }

    public void makeBridge(BridgeSize size) {
        List<String> bridge = bridgeMaker.makeBridge(size.getValue());
        gameRepository.save(new Bridge(bridge));
    }

    public ApplicationStatus retry() {
        bridgeGame.retry(gameRepository);
        return ApplicationStatus.GAME_START;
    }

    public void setIsSuccessInGame() {
        gameRepository.setIsSuccessInGame();
    }

    public boolean isRoundEnd(int index, MovingCommand movingCommand) {
        Bridge bridge = gameRepository.getBridge();
        return !bridge.check(index, movingCommand.getValue());
    }

    public BridgeMap move(int index, MovingCommand movingCommand) {
        BridgeMap bridgeMap = gameRepository.getBridgeMap();

        RoundStatus roundStatus;
        if (gameRepository.isGo(index, movingCommand)) {
            roundStatus = RoundStatus.ROUND_CONTINUE;
        } else {
            roundStatus = RoundStatus.ROUND_END;
        }

        bridgeGame.move(bridgeMap, movingCommand, roundStatus);
        return bridgeMap;
    }

    public int getBridgeSize() {
        return gameRepository.getSize();
    }

    public GameResult getResult() {
        return new GameResult(gameRepository.getAttempts(), gameRepository.getIsSuccessInGame(), gameRepository.getBridgeMap());
    }
}
