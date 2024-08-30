package bridge.model;

import bridge.utils.enums.ErrorMessage;

import static bridge.utils.enums.Const.BRIDGE_MAX_SIZE;
import static bridge.utils.enums.Const.BRIDGE_MIN_SIZE;

public class BridgeSize {
    private final int value;

    public BridgeSize(int value) {
        validate(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void validate(int value) {
        validateNumberRange(value);
    }

    private void validateNumberRange(int value) {
        if (value < BRIDGE_MIN_SIZE.getNumber() || value > BRIDGE_MAX_SIZE.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getMessage());
        }
    }
}
