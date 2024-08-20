package bridge.model;

import bridge.util.constant.Errors;
import bridge.util.constant.Numbers;

import java.util.regex.Pattern;

public class BridgeLength {
    private final int length;

    public BridgeLength(String length) {
        this.length = validate(length);
    }

    private int validate(String length) {
        //숫자로 이루어져있는 지 구성 → 숫자가 범위 내의 숫자인지
        return validateRange(isNumber(length));
    }

    private int isNumber(String length) {
        if(!Pattern.matches("^[0-9]+$", length)) {
            throw new IllegalArgumentException(Errors.NOT_NUMBER_ERROR.getMessage());
        }
        return Integer.parseInt(length);
    }

    private int validateRange(int length) {
        if(length >= Numbers.MIN_LENGTH.getNumber() && length <= Numbers.MAX_LENGTH.getNumber()) {
            throw new IllegalArgumentException(Errors.NOT_IN_RANGE_LENGTH_ERROR.getMessage());
        }
        return length;
    }

    public int getLength() {
        return length;
    }
}
