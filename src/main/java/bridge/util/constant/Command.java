package bridge.util.constant;

import static bridge.util.constant.Errors.INVALID_COMMAND_KEY_ERROR;

public enum Command {
    RETRY("R"),
    QUIT("Q");

    private final String command;
    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static Command getEnum(String command) {
        for (Command value : values()) {
            if(value.getCommand().equals(command)){
                return value;
            }
        }
        throw new IllegalArgumentException(INVALID_COMMAND_KEY_ERROR.getMessage());
    }
}
