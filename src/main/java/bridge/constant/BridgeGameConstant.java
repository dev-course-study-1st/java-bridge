package bridge.constant;

public enum BridgeGameConstant {
    BRIDGE_MIN_LENGTH(3),
    BRIDGE_MAX_LENGTH(20);

    private final int value;

    BridgeGameConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
