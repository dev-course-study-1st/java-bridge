package bridge.repository;

import bridge.domain.Bridge;
import bridge.domain.BridgeMap;
import bridge.domain.MovingCommand;

public class GameRepository {
    private int attempts;
    private boolean isSuccessInGame;
    private Bridge bridge;
    private BridgeMap bridgeMap;

    public GameRepository() {
        this.attempts = 1;
        this.isSuccessInGame = false;
        this.bridgeMap = new BridgeMap();
    }

    public void addAttempts() {
        attempts++;
    }

//    public void updateDiagram(MovingCommand movingCommand, RoundStatus roundStatus) {
//        bridgeMap.updateDiagram(bridgeSign, roundStatus);
//    }

    public void setIsSuccessInGame() {
        isSuccessInGame = true;
    }

    public void resetDiagrams() {
        bridgeMap = new BridgeMap();
    }

    public boolean getIsSuccessInGame() {
        return isSuccessInGame;
    }

    public int getAttempts() {
        return attempts;
    }

    public void save(Bridge bridge) {
        this.bridge = bridge;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public int getSize() {
        return this.bridge.getValue().size();
    }
}
