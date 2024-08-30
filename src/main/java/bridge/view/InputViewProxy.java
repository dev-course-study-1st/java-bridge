package bridge.view;

import bridge.domain.BridgeSize;
import bridge.domain.MovingCommand;
import bridge.domain.RestartCommand;
import bridge.util.ExceptionHandler;

public class InputViewProxy {

    private InputViewProxy() { }

    public static BridgeSize readBridgeSize() {
        return ExceptionHandler.handle(InputView::readBridgeSize);
    }

    public static MovingCommand readMoving() {
        return ExceptionHandler.handle(InputView::readMoving);
    }

    public static RestartCommand readGameCommand() {
        return ExceptionHandler.handle(InputView::readGameCommand);
    }
}
