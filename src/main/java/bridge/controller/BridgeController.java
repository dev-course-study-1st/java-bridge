package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeSize;
import bridge.service.BridgeService;
import bridge.view.InputViewProxy;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

    private final BridgeService bridgeService;

    public BridgeController(BridgeService bridgeService) {
        this.bridgeService = bridgeService;
        OutputView.printStartMessage();
    }

    public void run() {
        BridgeSize size = InputViewProxy.readBridgeSize();
        System.out.println(size.getValue());
        Bridge bridge = bridgeService.makeBridge(size);
        List<String> value = bridge.getValue();
        for (String s : value) {
            System.out.println("s = " + s);
        }
    }
}
