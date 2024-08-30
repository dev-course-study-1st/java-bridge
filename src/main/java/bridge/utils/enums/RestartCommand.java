package bridge.utils.enums;

public enum RestartCommand {
    RESTART("R"),
    QUIT("Q");

    private final String command;

    RestartCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public boolean isEqualTo(String command){
        return this.command.equals(command);
    }

}
