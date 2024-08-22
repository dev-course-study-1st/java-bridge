package bridge.service;

import bridge.BridgeMaker;
import bridge.domain.ApplicationStatus;
import bridge.domain.Bridge;
import bridge.domain.BridgeSize;
import bridge.domain.MovingCommand;
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
        List<String> bride = bridgeMaker.makeBridge(size.getValue());
        gameRepository.save(new Bridge(bride));
    }

    public ApplicationStatus retry() {
        bridgeGame.retry();
        return ApplicationStatus.GAME_START;
    }

    public void setIsSuccessInGame() {
        gameRepository.setIsSuccessInGame();
    }

    public boolean isRoundEnd(int index, MovingCommand movingCommand) {
        Bridge bridge = gameRepository.getBridge();
        return bridge.check(index, movingCommand.getValue());
    }

    public void move(int index, MovingCommand movingCommand) {

    }

    public int getBridgeSize() {
        return gameRepository.getSize();
    }
}
