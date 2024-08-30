package bridge.domain;

import static bridge.util.Constant.FIRST_TRY;

public class GameStatus {

    private int tryCount;
    private boolean isSuccess;

    public GameStatus() {
        this.tryCount = FIRST_TRY.getValue();
        this.isSuccess = false;
    }

    public void addTryCount() {
        this.tryCount++;
    }

    public void success() {
        this.isSuccess = true;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getTryCount() {
        return tryCount;
    }
}
