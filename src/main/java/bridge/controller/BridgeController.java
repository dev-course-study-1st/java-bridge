package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeSize;
import bridge.domain.MovingCommand;
import bridge.service.BridgeService;
import bridge.view.InputViewProxy;
import bridge.view.OutputView;

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
        while (true) {
            MovingCommand movingCommand = InputViewProxy.readMoving();
        }
    }
}
