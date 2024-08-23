package bridge.utils.enums;

public enum IOMessage {
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_DIRECTION("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_GAME_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    OUTPUT_GAME_START("다리 건너기 게임을 시작합니다."),
    OUTPUT_GAME_RESULT("최종 게임 결과"),
    OUTPUT_SUCCESS_RESULT("게임 성공 여부: "),
    OUTPUT_SUCCESS("성공"),
    OUTPUT_FAIL("실패"),
    OUTPUT_ATTEMPT("총 시도한 횟수: "),
    ;

    private final String message;

    IOMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    }
