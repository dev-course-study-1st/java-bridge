package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class BridgeState {
    private final List<MoveResult> moveResults;

    public BridgeState() {
        this.moveResults = new ArrayList<>();
    }

    public void addMoveResult(MoveResult moveResult) {
        moveResults.add(moveResult);
    }

    public List<MoveResult> getMoveResults(){
        return moveResults;
    }

    public void clear() {
        moveResults.clear();
    }

    public boolean isSuccess() {
        return moveResults.stream()
                .allMatch(MoveResult::isSuccess);
    }
}
