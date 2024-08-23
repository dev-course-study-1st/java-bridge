package bridge;

import static bridge.domain.MovingCommand.*;

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
        int generate = bridgeNumberGenerator.generate();
        if (generate == 0) {
            return DOWN.getValue();
        }
        return UP.getValue();
    }
}
