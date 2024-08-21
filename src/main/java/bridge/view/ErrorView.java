package bridge.view;

public class ErrorView {

    private static final String ERROR_FORMAT = "[ERROR] %s\n";

    private ErrorView() { }

    public static void printError(String errorMessage) {
        System.out.printf(ERROR_FORMAT, errorMessage);
    }

}
