package bridge.model;

import bridge.utils.enums.MoveCommend;

public class MoveResult {
    private final boolean success;
    private final MoveCommend direction;

    public MoveResult(boolean success, MoveCommend moveCommend) {
        this.success = success;
        this.direction = moveCommend;
    }

    public boolean isSuccess(){
        return success;
    }

    public String getDirection(){
        return direction.getCommend();
    }

}
