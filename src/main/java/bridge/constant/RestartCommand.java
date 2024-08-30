package bridge.constant;

public enum RestartCommand {
    RESTART("R"),
    QUIT("Q");

    private final String command;

    RestartCommand(String command) {
        this.command = command;
    }

    public static RestartCommand stringToCommand(String command) {
        for (RestartCommand restartCommand : values()) {
            if (restartCommand.command.equals(command)) {
                return restartCommand;
            }
        }
        throw new IllegalArgumentException("R 또는 Q를 입력해주세요.");
    }
}
