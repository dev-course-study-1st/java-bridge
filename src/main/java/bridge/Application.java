package bridge;

import bridge.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        BridgeGameController bridgeGameController = appConfig.setGame();
        bridgeGameController.run();
    }
}
