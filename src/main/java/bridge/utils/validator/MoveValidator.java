package bridge.utils.validator;

import bridge.utils.enums.ErrorMessage;

import static bridge.utils.enums.MoveCommend.DOWN;
import static bridge.utils.enums.MoveCommend.UP;

public class MoveValidator {

    private MoveValidator() {
    }

    public static String validate(String input) {
        return validateDirection(input);
    }

    private static String validateDirection(String input) {
        if (!input.equals(UP.getCommend()) && !input.equals(DOWN.getCommend())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DIRECTION.getMessage());
        }
        return input;
    }

}
