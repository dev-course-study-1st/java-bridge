package bridge.util.constant;

public enum Messages {

    START_MSG("다리 건너기 게임을 시작합니다.\n"),
    INPUT_LENGTH_MSG("다리의 길이를 입력해주세요.")
    ;

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
