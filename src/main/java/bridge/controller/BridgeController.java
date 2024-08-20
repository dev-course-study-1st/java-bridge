package bridge.controller;

import bridge.model.BridgeLength;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    public void run() {
        OutputView.printStart();
        start();
    }

    private void start() {
        BridgeLength length = InputView.readBridgeSize();

    }
}
