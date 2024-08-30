package bridge.constant;

public enum RestartCommand {
    RESTART("R",true),
    QUIT("Q",false);

    private final String command;
    private final boolean isRestart;

    RestartCommand(String command, boolean isRestart) {
        this.command = command;
        this.isRestart = isRestart;
    }

    public static boolean isRestart(String command) {
        return stringToCommand(command).isRestart;
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
