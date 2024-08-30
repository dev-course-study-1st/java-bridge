package bridge;

import bridge.domain.MovingCommand;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(getUnit());
        }
        return result;
    }

    private String getUnit() {
        return MovingCommand.findByNumber(bridgeNumberGenerator.generate());
    }
}
