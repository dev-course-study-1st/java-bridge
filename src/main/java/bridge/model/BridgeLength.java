package bridge.model;

import bridge.util.constant.Errors;
import bridge.util.constant.Numbers;

public class BridgeLength {
    private final int length;

    public BridgeLength(String length) {
        validate(length);
        this.length = Integer.parseInt(length);
    }

    private static void validate(String length) {
        //숫자로 이루어져있는 지 구성 → 숫자가 범위 내의 숫자인지
        isNumber(length);
        int number = Integer.parseInt(length);
        validateRange(number);
    }

    private static  void isNumber(String input) {
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Errors.NOT_NUMBER_ERROR.getMessage());
        }
    }

    private static  void validateRange(int length) {
        if(!(length >= Numbers.MIN_LENGTH.getNumber() && length <= Numbers.MAX_LENGTH.getNumber())) {
            throw new IllegalArgumentException(Errors.NOT_IN_RANGE_LENGTH_ERROR.getMessage());
        }
    }

    public int getLength() {
        return length;
    }
}
