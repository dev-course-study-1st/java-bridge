package bridge.model;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.util.constant.MoveKey;

import java.util.List;

public class SystemBridge extends Bridge {

    private static final BridgeNumberGenerator GENERATOR = new BridgeRandomNumberGenerator();
    public SystemBridge(BridgeLength bridgeLength) {
        super(makeBridge(bridgeLength));
    }

    private static List<String> makeBridge(BridgeLength bridgeLength) {
        final BridgeMaker bridgeMaker = new BridgeMaker(GENERATOR);
        return bridgeMaker.makeBridge(bridgeLength.getLength());
    }

    @Override
    public void clear() {}

    @Override
    public void add(MoveKey moveKey) {}
}
