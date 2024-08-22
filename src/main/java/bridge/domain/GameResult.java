package bridge.domain;

public class GameResult {

    private final int tryCount;
    private final boolean isSuccess;
    private final BridgeMap bridgeMap;

    public GameResult(int tryCount, boolean isSuccess, BridgeMap bridgeMap) {
        this.tryCount = tryCount;
        this.isSuccess = isSuccess;
        this.bridgeMap = bridgeMap;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getTryCount() {
        return tryCount;
    }

    public BridgeMap getBridgeMap() {
        return bridgeMap;
    }
}
