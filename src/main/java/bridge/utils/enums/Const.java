package bridge.utils.enums;

public enum Const {
    BRIDGE_MIN_SIZE(3),
    BRIDGE_MAX_SIZE(20),
    ;

    private final int number;

    Const(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
