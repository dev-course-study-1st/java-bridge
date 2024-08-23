package bridge;

import bridge.controller.BridgeGameController;
import bridge.model.BridgeMaker;
import bridge.model.BridgeState;
import bridge.service.BridgeGameService;
import bridge.utils.generator.BridgeRandomNumberGenerator;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController(new BridgeGameService(new BridgeMaker(new BridgeRandomNumberGenerator()), new BridgeState()));
        bridgeGameController.run();
    }
}
