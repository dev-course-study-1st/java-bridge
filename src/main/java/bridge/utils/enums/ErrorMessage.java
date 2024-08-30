package bridge.utils.enums;

public enum ErrorMessage {
    INVALID_NUMBER("올바른 숫자를 입력해야합니다."),
    INVALID_RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_DIRECTION("U(위 칸) 혹은 D(아래 칸)만 입력해야 합니다."),
    INVALID_GENERATE("올바르지 않은 숫자 생성입니다."),
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
