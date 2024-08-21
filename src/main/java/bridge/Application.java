package bridge;

import bridge.controller.BridgeController;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        BridgeController bridgeController = appConfig.setSystem();
        bridgeController.run();
        appConfig.close();
    }
}
