package bridge.util;

import bridge.domain.BridgeMap;
import bridge.domain.GameResult;
import java.util.List;
import java.util.StringJoiner;

public class StringUtil {

    private static final String DELIMITER = " | ";
    private static final String PREFIX = "[ ";
    private static final String SUFFIX = " ]\n";
    private static final String RESULT_MESSAGE = "게임 성공 여부: %s\n";
    private static final String TRY_COUNT_MESSAGE = "총 시도한 횟수: %s\n";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    private StringUtil() { }

    public static String formatBridgeMap(BridgeMap bridgeMap) {
        return formatDiagram(bridgeMap.getUpperMap())
                + formatDiagram(bridgeMap.getLowerMap());
    }

    private static String formatDiagram(List<String> diagrams) {
        StringJoiner stringJoiner = new StringJoiner(DELIMITER, PREFIX, SUFFIX);
        for (String diagram : diagrams) {
            stringJoiner.add(diagram);
        }
        return stringJoiner.toString();
    }

    public static String formatResult(GameResult gameResult) {
        return String.format(RESULT_MESSAGE, getResultWord(gameResult.isSuccess()))
                + String.format(TRY_COUNT_MESSAGE, gameResult.getTryCount());
    }

    private static String getResultWord(boolean isSuccess) {
        if (isSuccess) {
            return SUCCESS;
        }
        return FAIL;
    }
}
