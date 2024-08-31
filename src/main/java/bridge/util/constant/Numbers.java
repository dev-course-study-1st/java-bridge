package bridge.util.constant;

public enum Numbers {

    BRIDGE_START(0),
    MIN_LENGTH(3),
    MAX_LENGTH(20);

    private final int number;

    Numbers(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
