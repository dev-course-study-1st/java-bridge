package bridge.util.constant;

import java.util.Arrays;

public enum GameResult {

    SUCCESS(true, "성공"),
    FAILURE(false, "실패");

    private final boolean isSucceed;
    private final String result;
    GameResult(boolean isSucceed, String result) {
        this.isSucceed = isSucceed;
        this.result = result;
    }

    @Override
    public String toString() {
        return result;
    }

    public static GameResult getGameResult(boolean isSucceed) {
        return Arrays.stream(values())
                .filter(value -> value.isSucceed == isSucceed)
                .findFirst().get();
    }
}
