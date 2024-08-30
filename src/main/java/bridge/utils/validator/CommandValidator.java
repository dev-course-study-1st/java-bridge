package bridge.utils.validator;

import bridge.utils.enums.ErrorMessage;

import static bridge.utils.enums.RestartCommand.QUIT;
import static bridge.utils.enums.RestartCommand.RESTART;

public class CommandValidator {

    private CommandValidator() {
    }

    public static String validate(String input) {
        return validateCommand(input);
    }

    private static String validateCommand(String input) {
        if (!input.equals(RESTART.getCommand()) && !input.equals(QUIT.getCommand())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DIRECTION.getMessage());
        }
        return input;
    }
}
