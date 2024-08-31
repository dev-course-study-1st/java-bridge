package bridge.util.constant;

public enum Messages {

    START_MSG("다리 건너기 게임을 시작합니다.\n"),
    INPUT_LENGTH_MSG("다리의 길이를 입력해주세요."),
    INPUT_MOVE_KEY_MSG("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RETRY_OR_QUIT_MSG("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    FINAL_RESULT("최종 게임 결과"),
    GAME_SUCCEED_OR_NOT_MSG("게임 성공 여부: "),
    TOTAL_PRICE_MSG("총 시도한 횟수: ");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
