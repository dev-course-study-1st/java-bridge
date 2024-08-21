package bridge.view;

import bridge.domain.BridgeSize;
import bridge.util.ExceptionHandler;

public class InputViewProxy {

    private InputViewProxy() { }

    public static BridgeSize readBridgeSize() {
        return ExceptionHandler.handle(InputView::readBridgeSize);
    }

}
