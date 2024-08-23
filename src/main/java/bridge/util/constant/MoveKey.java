package bridge.util.constant;

import java.util.Arrays;
import java.util.Optional;

public enum MoveKey {
    DOWN("D", 0),
    UP("U", 1);

    private final String moveKey;
    private final int line;

    MoveKey(String moveKey, int line) {
        this.moveKey = moveKey;
        this.line = line;
    }

    public String getMoveKey() {
        return moveKey;
    }

    public int getLine() {
        return line;
    }

    public static Optional<MoveKey> getEnum(String moveKey) {
        return Arrays.stream(values())
                .filter(key -> key.getMoveKey().equals(moveKey))
                .findFirst();
    }
}
