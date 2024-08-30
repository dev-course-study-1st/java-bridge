package bridge.model;

import static bridge.utils.enums.Const.BRIDGE_INIT_NUMBER;

public class Position {
    private int value;

    public Position() {
        this.value = BRIDGE_INIT_NUMBER.getNumber();
    }

    public int getValue() {
        return value;
    }

    public void increment() {
        value++;
    }

    public void reset() {
        this.value = BRIDGE_INIT_NUMBER.getNumber();
    }
}
