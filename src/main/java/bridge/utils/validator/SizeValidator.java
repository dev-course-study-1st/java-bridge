package bridge.utils.validator;

import bridge.utils.enums.ErrorMessage;

import static bridge.utils.enums.Const.*;

public class SizeValidator {
    private static final String IS_DIGIT = "^[1-9]\\d*$";

    private SizeValidator() {
    }

    public static int validate(String input) {
        return validateNumberRange(validateNumber(input));
    }

    private static int validateNumberRange(int size) {
        if (size < BRIDGE_MIN_SIZE.getNumber() || size > BRIDGE_MAX_SIZE.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getMessage());
        }
        return size;
    }

    private static int validateNumber(String input) {
        if (!input.matches(IS_DIGIT)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }
        return Integer.parseInt(input);
    }

}
