package bridge.domain;

import static bridge.util.Constant.BRIDGE_MAX_SIZE;
import static bridge.util.Constant.BRIDGE_MIN_SIZE;

public class BridgeSize {

    private final int value;

    public BridgeSize(int value) {
        checkSize(value);
        this.value = value;
    }

    private void checkSize(int value) {
        if (value < BRIDGE_MIN_SIZE.getValue() || value > BRIDGE_MAX_SIZE.getValue()) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
