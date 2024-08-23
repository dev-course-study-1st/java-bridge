package bridge.model;

import bridge.constant.BridgeEnum;
import bridge.constant.BridgeGameConstant;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        validate(bridge);
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    private void validate(List<String> bridge) {
        if (!validateBridgeSize(bridge)) {
            throw new IllegalArgumentException("다리의 길이는 " + BridgeGameConstant.BRIDGE_MIN_LENGTH.getValue() + " 이상 " + BridgeGameConstant.BRIDGE_MAX_LENGTH.getValue() + " 이하여야 합니다.");
        }
        if (!validateBridgeSegment(bridge)) {
            throw new IllegalArgumentException("다리의 형태는 U 또는 D 이어야 합니다.");
        }
    }

    private boolean validateBridgeSize(List<String> bridge) {
        return bridge.size() >= BridgeGameConstant.BRIDGE_MIN_LENGTH.getValue() && bridge.size() <= BridgeGameConstant.BRIDGE_MAX_LENGTH.getValue();
    }

    public boolean validateBridgeSegment(List<String> bridge) {
        return bridge.stream().allMatch(segment -> segment.equals(BridgeEnum.UP.getBridgeSegmentStringType()) || segment.equals(BridgeEnum.DOWN.getBridgeSegmentStringType()));
    }
}
