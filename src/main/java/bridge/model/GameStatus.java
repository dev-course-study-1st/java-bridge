package bridge.model;

public class GameStatus {
    private boolean isGameRunning;
    private boolean isGameSuccess;
    private int tryCount;

    public GameStatus() {
        this.isGameRunning = true;
        this.isGameSuccess = false;
        this.tryCount = 1;
    }

    public void failGame() {
        isGameRunning = false;
    }

    public void retryGame() {
        isGameRunning = true;
        increaseTryCount();
    }

    private void increaseTryCount() {
        tryCount++;
    }

    public boolean isGameRunning() {
        return isGameRunning;
    }

    public boolean isGameSuccess() {
        return isGameSuccess;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void endGame() {
        isGameRunning = false;
        isGameSuccess = true;
    }
}
