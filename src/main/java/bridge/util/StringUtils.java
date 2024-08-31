package bridge.util;

import bridge.util.constant.MoveKey;
import bridge.util.constant.Numbers;

import java.util.List;
import java.util.StringJoiner;

public class StringUtils {

    private final String BRIDGE_START = "[";
    private final String BRIDGE_END = "]";
    private final String BLANK = " ";

    public String createLine(List<String> userBridge, List<String> bridgeLog, MoveKey moveKey) {
        StringJoiner sj = new StringJoiner("|");

        for (int index = Numbers.BRIDGE_START.getNumber(); index < userBridge.size(); index++) {
            String bridgeBlock = getBridgeBlock(userBridge.get(index), bridgeLog.get(index), moveKey);
            sj.add(bridgeBlock);
        }
        return BRIDGE_START + sj + BRIDGE_END;
    }

    private String getBridgeBlock(String userBridge, String bridgeLog, MoveKey moveKey) {
        if(userBridge.equals(moveKey.getMoveKey())) {
            return BLANK + bridgeLog + BLANK;
        }
        return BLANK.repeat(3);
    }
}
