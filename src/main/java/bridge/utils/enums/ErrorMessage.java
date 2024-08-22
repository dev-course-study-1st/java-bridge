package bridge.utils.enums;

public enum ErrorMessage {
    INVALID_NUMBER("올바른 숫자를 입력해주세요"),
    INVALID_RANGE("3 ~ 20 사이의 사이즈를 입력해주세요"),
    INVALID_DIRECTION("U(위 칸) 혹은 D(아래 칸)만 입력해주세요")
    ;

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return ERROR_PREFIX + message;
    }
}
