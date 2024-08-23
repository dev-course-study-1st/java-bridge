package bridge.util.constant;

import java.util.Optional;

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

    public static Optional<Command> getEnum(String command) {
        for (Command value : values()) {
            if(value.getCommand().equals(command)){
                return Optional.of(value);
            }
        }
        return Optional.empty();
    }
}
