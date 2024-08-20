package bridge.util.constant;

public enum Command {
    U("Up"),
    D("Down"),
    R("Retry"),
    Q("Quit");

    private final String command;
    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
