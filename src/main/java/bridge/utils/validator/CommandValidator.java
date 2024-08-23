package bridge.utils.validator;

import bridge.utils.enums.ErrorMessage;

import static bridge.utils.enums.RestartCommend.QUIT;
import static bridge.utils.enums.RestartCommend.RESTART;

public class CommandValidator {

    private CommandValidator() {
    }

    public static String validate(String input) {
        return validateCommend(input);
    }

    private static String validateCommend(String input) {
        if (!input.equals(RESTART.getCommend()) && !input.equals(QUIT.getCommend())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DIRECTION.getMessage());
        }
        return input;
    }
}
