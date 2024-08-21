package bridge.util;

public enum Constant {

    BRIDGE_MAX_SIZE(20),
    BRIDGE_MIN_SIZE(3);

    private final int value;

    Constant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
