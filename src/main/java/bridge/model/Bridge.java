package bridge.model;

import bridge.utils.enums.MoveCommand;

import java.util.List;

public class Bridge {
    private final List<String> bridgeDirections;

    public Bridge(List<String> bridgeDirections) {
        this.bridgeDirections = bridgeDirections;
    }

    public List<String> getBridge() {
        return bridgeDirections;
    }

    public int getSize(){
        return bridgeDirections.size();
    }

    public boolean isRightDirection(Position currentPosition, MoveCommand direction) {
        return bridgeDirections.get(currentPosition.getValue()).equals(direction.getCommand());
    }
}
