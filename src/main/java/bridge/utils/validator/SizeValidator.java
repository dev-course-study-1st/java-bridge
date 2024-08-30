package bridge.utils.validator;

import bridge.utils.enums.ErrorMessage;

import static bridge.utils.enums.Const.*;

public class SizeValidator {
    private static final String IS_DIGIT = "^[1-9]\\d*$";

    private SizeValidator() {
    }

    public static int validate(String input) {
        return (validateNumber(input));
    }

    private static int validateNumber(String input) {
        if (!input.matches(IS_DIGIT)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }
        return Integer.parseInt(input);
    }

}
