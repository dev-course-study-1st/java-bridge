package bridge;

import bridge.controller.BridgeGameController;
import bridge.model.BridgeMaker;
import bridge.model.BridgeState;
import bridge.service.BridgeGameService;
import bridge.utils.generator.BridgeNumberGenerator;
import bridge.utils.generator.BridgeRandomNumberGenerator;

public class AppConfig {
    public BridgeGameController setGame() {
        return new BridgeGameController(bridgeGameService());
    }

    private BridgeGameService bridgeGameService() {
        return new BridgeGameService(bridgeMaker(), bridgeState());
    }

    private BridgeMaker bridgeMaker() {
        return new BridgeMaker(bridgeNumberGenerator());
    }

    private BridgeNumberGenerator bridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }

    private BridgeState bridgeState() {
        return new BridgeState();
    }
}
