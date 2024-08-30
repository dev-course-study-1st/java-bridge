package bridge.view;

import java.util.List;
import java.util.StringJoiner;

public class StringUtil {

    public static String createBridge(List<String> userBridge, List<String> gameBridge) {
        StringJoiner bridge = new StringJoiner("\n");

        StringJoiner upBridge = new StringJoiner(" | ");
        StringJoiner downBridge = new StringJoiner(" | ");

        for (int i = 0; i < userBridge.size(); i++) {
            addBridgeSegment(userBridge.get(i), gameBridge.get(i), upBridge, downBridge);
        }
        return bridge.add(String.format("[ %s ]", upBridge)).add(String.format("[ %s ]", downBridge)).toString();
    }

    private static void addBridgeSegment(String userSegment, String gameSegment, StringJoiner upBridge, StringJoiner downBridge) {
        if (userSegment.equals(gameSegment)) {
            addMatchingSegment(userSegment, upBridge, downBridge);
        } else {
            addNonMatchingSegment(userSegment, upBridge, downBridge);
        }
    }

    private static void addMatchingSegment(String segment, StringJoiner upBridge, StringJoiner downBridge) {
        if (segment.equals("U")) {
            upBridge.add("O");
            downBridge.add(" ");
        } else if (segment.equals("D")) {
            upBridge.add(" ");
            downBridge.add("O");
        }
    }

    private static void addNonMatchingSegment(String segment, StringJoiner upBridge, StringJoiner downBridge) {
        if (segment.equals("U")) {
            upBridge.add("X");
            downBridge.add(" ");
        } else if (segment.equals("D")) {
            upBridge.add(" ");
            downBridge.add("X");
        }
    }
}
