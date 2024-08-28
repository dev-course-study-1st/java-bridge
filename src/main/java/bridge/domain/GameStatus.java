package bridge.domain;

public class GameStatus {

    private int tryCount;
    private boolean isSuccess;

    public GameStatus() {
        this.tryCount = 1;
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
