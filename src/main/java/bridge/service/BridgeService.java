package bridge.service;

import bridge.BridgeMaker;
import bridge.domain.Bridge;
import bridge.domain.BridgeSize;
import java.util.List;

public class BridgeService {

    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;

    public BridgeService(BridgeMaker bridgeMaker, BridgeGame bridgeGame) {
        this.bridgeMaker = bridgeMaker;
        this.bridgeGame = bridgeGame;
    }

    public Bridge makeBridge(BridgeSize size) {
        List<String> bride = bridgeMaker.makeBridge(size.getValue());
        return new Bridge(bride);
    }
}
