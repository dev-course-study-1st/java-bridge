package bridge.utils.handler;

import java.util.function.Supplier;

public class InputHandler {
    public static <T> T handleInput(Supplier<T> inputMethod) {
        while (true) {
            try {
                return inputMethod.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
