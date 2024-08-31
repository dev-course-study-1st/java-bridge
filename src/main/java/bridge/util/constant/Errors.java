package bridge.util.constant;

public enum Errors {

    NOT_NUMBER_ERROR("다리 길이는 숫자여야 합니다."),
    NOT_IN_RANGE_LENGTH_ERROR("다리 길이는 3이상 20이하여야 합니다."),
    INVALID_MOVE_KEY_ERROR("U 또는 D를 입력해야 합니다."),

    INVALID_COMMAND_KEY_ERROR("재시도(R), 종료(Q) 중에 입력해야 합니다.");

    private final String message;

    Errors (String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
