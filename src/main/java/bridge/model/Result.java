package bridge.model;

import bridge.util.constant.GameResult;

public class Result {

    private final int totalTrial;
    private final GameResult gameResult;

    public Result(int totalTrial, GameResult gameResult) {
        this.totalTrial = totalTrial;
        this.gameResult = gameResult;
    }

    public int getTotalTrial() {
        return totalTrial;
    }

    public GameResult getGameResult() {
        return gameResult;
    }
}
