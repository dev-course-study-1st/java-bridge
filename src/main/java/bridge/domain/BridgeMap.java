package bridge.domain;

import static bridge.domain.RoundStatus.*;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {

    private List<String> upperMap;
    private List<String> lowerMap;

    public BridgeMap() {
        this.upperMap = new ArrayList<>();
        this.lowerMap = new ArrayList<>();
    }

    public void updateMap(MovingCommand movingCommand, RoundStatus roundStatus) {
        if (movingCommand == MovingCommand.UP) {
            upperMap.add(roundStatus.getValue());
            lowerMap.add(SPACE.getValue());
        }
        if (movingCommand == MovingCommand.DOWN) {
            upperMap.add(SPACE.getValue());
            lowerMap.add(roundStatus.getValue());
        }
    }

    public void reset() {
        this.upperMap = new ArrayList<>();
        this.lowerMap = new ArrayList<>();
    }

    public List<String> getUpperMap() {
        return upperMap;
    }

    public List<String> getLowerMap() {
        return lowerMap;
    }
}
