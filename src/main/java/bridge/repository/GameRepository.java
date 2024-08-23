package bridge.repository;

import static bridge.util.Constant.FIRST_TRY;

import bridge.domain.Bridge;
import bridge.domain.MovingCommand;

public class GameRepository {
    private int tryCount;
    private boolean isSuccess;
    private Bridge bridge;

    public GameRepository() {
        this.tryCount = FIRST_TRY.getValue();
        this.isSuccess = false;
    }

    public void addAttempts() {
        tryCount++;
    }

    public void setIsSuccessInGame() {
        isSuccess = true;
    }

    public boolean getIsSuccessInGame() {
        return isSuccess;
    }

    public int getAttempts() {
        return tryCount;
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

    public boolean isGo(int index, MovingCommand movingCommand) {
        return this.bridge.canGo(index, movingCommand.getValue());
    }

}
