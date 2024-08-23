package bridge.model;

public class Position {
    private int value;

    public Position(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void increment() {
        value++;
    }

    public void reset(int value) {
        this.value = value;
    }
}
