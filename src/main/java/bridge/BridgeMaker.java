package bridge;

import bridge.constant.BridgeGameConstant;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validate(size);
        List<String> bridge = new ArrayList<>();
        for(int i=0; i<size; i++) {
            bridge.add(generateBridgeSegment());
        }
        return bridge;
    }

    private String generateBridgeSegment() {
        int bridgeNumber = bridgeNumberGenerator.generate();
        if(bridgeNumber==0) {
            return "D";
        }
        if(bridgeNumber==1) {
            return "U";
        }
        throw new IllegalArgumentException("다리의 형태는 0 또는 1이어야 합니다.");
    }

    private void validate(int size) {
        if(!validateBridgeSize(size)) {
            throw new IllegalArgumentException("다리의 길이는 " + BridgeGameConstant.BRIDGE_MIN_LENGTH.getValue() + " 이상 " + BridgeGameConstant.BRIDGE_MAX_LENGTH.getValue() + " 이하여야 합니다.");
        }
    }

    private boolean validateBridgeSize(int size) {
        return size >= BridgeGameConstant.BRIDGE_MIN_LENGTH.getValue() && size <= BridgeGameConstant.BRIDGE_MAX_LENGTH.getValue();
    }
}
