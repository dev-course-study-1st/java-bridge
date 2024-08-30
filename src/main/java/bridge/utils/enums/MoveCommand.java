package bridge.utils.enums;

public enum MoveCommand {
    UP("U", 1),
    DOWN("D", 0);

    private final String command;
    private final int number;

    MoveCommand(String command, int number) {
        this.command = command;
        this.number = number;
    }

    public String getCommand() {
        return command;
    }

    public static String numberOf(int number) {
        for(MoveCommand moveCommand:values()){
            if (moveCommand.number == number) {
                return moveCommand.command;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_GENERATE.getMessage());
    }

    public static MoveCommand fromString(String command) {
        for (MoveCommand moveCommand : MoveCommand.values()) {
            if (moveCommand.getCommand().equalsIgnoreCase(command)) {
                return moveCommand;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_DIRECTION.getMessage());
    }

    public boolean isEqualTo(String command){
        return this.command.equals(command);
    }
}
