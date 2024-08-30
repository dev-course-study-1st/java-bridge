package bridge.model;

import bridge.utils.enums.MoveCommand;

public class MoveResult {
    private final boolean success;
    private final MoveCommand direction;

    public MoveResult(boolean success, MoveCommand moveCommand) {
        this.success = success;
        this.direction = moveCommand;
    }

    public boolean isSuccess(){
        return success;
    }

    public boolean isEqualDirection(MoveCommand direction){
        return this.direction.equals(direction);
    }

}
