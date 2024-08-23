package bridge.constant;

public enum BridgeEnum {
    UP("U", 1),
    DOWN("D", 0);

    private final String bridgeSegmentStringType;
    private final int bridgeSegmentIntType;

    BridgeEnum(String bridgeSegmentStringType, int bridgeSegmentIntType) {
        this.bridgeSegmentStringType = bridgeSegmentStringType;
        this.bridgeSegmentIntType = bridgeSegmentIntType;
    }

    public int getBridgeSegmentIntType() {
        return bridgeSegmentIntType;
    }

    public String getBridgeSegmentStringType() {
        return bridgeSegmentStringType;
    }
}
