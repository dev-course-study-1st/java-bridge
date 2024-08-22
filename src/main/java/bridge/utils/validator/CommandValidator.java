package bridge.utils.validator;

import bridge.utils.enums.ErrorMessage;

public class CommandValidator {
    private static final String RESTART = "R";
    private static final String QUIT = "Q";

    private CommandValidator(){
    }

    public static String validate(String input){
        return validateCommend(input);
    }
    private static String validateCommend(String input){
        if (!input.equals(RESTART) && !input.equals(QUIT)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DIRECTION.getMessage());
        }
        return input;
    }
}
