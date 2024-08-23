package bridge.view;

public enum GameMessage {
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_MOVING("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    OUTPUT_TOTAL_COUNT("총 시도한 횟수: %d \n"),
    OUTPUT_INIT_MESSAGE("다리 건너기 게임을 시작합니다."),
    OUTPUT_ERROR_MESSAGE("[ERROR] %s \n"),
    OUTPUT_GAME_RESULT("게임 성공 여부: %s \n"),
    OUTPUT_END_MESSAGE("최종 게임 결과"),
    GAME_SUCCESS("성공"),
    GAME_FAIL("실패");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
