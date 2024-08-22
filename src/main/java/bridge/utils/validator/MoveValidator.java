package bridge.utils.validator;

import bridge.utils.enums.ErrorMessage;

public class MoveValidator {
    private static final String UP = "U";
    private static final String DOWN = "D";

    private MoveValidator() {
    }

    public static String validate(String input) {
        return validateDirection(input);
    }

    private static String validateDirection(String input){
        if(!input.equals(UP)&&!input.equals(DOWN)){
            throw new IllegalArgumentException(ErrorMessage.INVALID_DIRECTION.getMessage());
        }
        return input;
    }

}
