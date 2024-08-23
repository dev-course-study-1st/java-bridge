package bridge.model;

import java.util.List;

public class Bridge {
    private final List<String> bridgeDirections;

    public Bridge(List<String> bridgeDirections) {
        this.bridgeDirections = bridgeDirections;
    }

    public List<String> getBridge() {
        return bridgeDirections;
    }

    public String getDirection(Position position){
        return bridgeDirections.get(position.getValue());
    }

    public int getSize(){
        return bridgeDirections.size();
    }
}
