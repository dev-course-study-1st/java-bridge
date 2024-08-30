package bridge.util;

import bridge.view.ErrorView;
import java.util.function.Supplier;

public class ExceptionHandler {

    private ExceptionHandler() { }

    public static <T> T handle(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            ErrorView.printError(e.getMessage());
            return handle(supplier);
        }
    }
}