package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class BridgeMap {

    private final List<String> upperMap;
    private final List<String> lowerMap;

    public BridgeMap() {
        this.upperMap = new ArrayList<>();
        this.lowerMap = new ArrayList<>();
    }

    public void updateMap(MovingCommand movingCommand, RoundStatus roundStatus) {
        if (movingCommand == MovingCommand.U) {
            upperMap.add(roundStatus.getValue());
            lowerMap.add(RoundStatus.SPACE.getValue());
        }
        if (movingCommand == MovingCommand.D) {
            upperMap.add(RoundStatus.SPACE.getValue());
            lowerMap.add(roundStatus.getValue());
        }
    }

    @Override
    public String toString() {
        return formatDiagram(upperMap)
                + formatDiagram(lowerMap);
    }

    private String formatDiagram(List<String> diagrams) {
        StringJoiner stringJoiner = new StringJoiner(" | ", "[ ", " ]\n");
        for (String diagram : diagrams) {
            stringJoiner.add(diagram);
        }
        return stringJoiner.toString();
    }

}
