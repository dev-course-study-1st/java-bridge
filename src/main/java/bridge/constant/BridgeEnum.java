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

    public String getBridgeSegmentStringType() {
        return bridgeSegmentStringType;
    }

    public static BridgeEnum intTypeToStringType(int bridgeSegmentIntType) {
        for (BridgeEnum bridgeEnum : values()) {
            if (bridgeEnum.bridgeSegmentIntType == bridgeSegmentIntType) {
                return bridgeEnum;
            }
        }
        throw new IllegalArgumentException("다리의 형태가 올바르지 않습니다.");
    }
}
