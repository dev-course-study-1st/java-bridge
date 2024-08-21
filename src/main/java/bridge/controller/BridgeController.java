package bridge.controller;

import bridge.domain.BridgeSize;
import bridge.view.InputViewProxy;
import bridge.view.OutputView;

public class BridgeController {

    public BridgeController() {
        OutputView.printStartMessage();
    }

    public void run() {

        BridgeSize size = InputViewProxy.readBridgeSize();
        System.out.println(size.getValue());

    }
}
