package bridge.model;

import bridge.constant.BridgeEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UserBridge {
    private List<String> userBridge;

    public UserBridge() {
        this.userBridge = new ArrayList<>();
    }

    public void addBridgeSegment(String moveCommand) {
        validateMoving(moveCommand);
        userBridge.add(moveCommand);
    }

    public void resetUserBridge() {
        userBridge.clear();
    }

    public int size() {
        return userBridge.size();
    }

    public List<String> getUserBridge() {
        return userBridge;
    }

    private void validateMoving(String moveCommand) {
        if (!isContainMoveCommand(moveCommand)) {
            throw new IllegalArgumentException("다리의 형태는 U 또는 D 이어야 합니다.");
        }
    }

    private boolean isContainMoveCommand(String command) {
        return Stream.of(BridgeEnum.values())
                .map(BridgeEnum::getBridgeSegmentStringType)
                .anyMatch(command::equals);
    }
}
