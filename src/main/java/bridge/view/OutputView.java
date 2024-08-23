package bridge.view;

import bridge.domain.BridgeMap;
import bridge.domain.GameResult;
import bridge.util.StringUtil;

public class OutputView {

    public static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    public static final String FINAL_RESULT_MESSAGE = "최종 게임 결과";

    public static void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printMap(BridgeMap bridgeMap) {
        System.out.println(StringUtil.formatBridgeMap(bridgeMap));
    }

    public static void printResult(GameResult gameResult) {
        System.out.println(FINAL_RESULT_MESSAGE);
        System.out.println(gameResult.getBridgeMap());
        System.out.println(StringUtil.formatResult(gameResult));
    }
}
