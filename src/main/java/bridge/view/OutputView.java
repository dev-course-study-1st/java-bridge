package bridge.view;

import bridge.model.Result;
import bridge.util.constant.Messages;
import bridge.util.constant.MoveKey;
import bridge.util.constant.Numbers;

import java.util.List;

import static bridge.util.constant.Messages.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStart() {
        System.out.println(Messages.START_MSG.getMessage());
    }

    public static void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> userBridge, List<String> bridgeLog) {
        printLine(userBridge, bridgeLog, MoveKey.UP);
        printLine(userBridge, bridgeLog, MoveKey.DOWN);
        System.out.println();
    }

    private void printLine(List<String> userBridge, List<String> bridgeLog, MoveKey moveKey) {
        int totalSize = userBridge.size();
        StringBuilder sb = new StringBuilder("[");
        for (int index = Numbers.BRIDGE_START.getNumber(); index < totalSize; index++) {
            sb.append(BLANK.getMessage())
                    .append(printBridgeBlock(userBridge.get(index), bridgeLog.get(index), moveKey))
                    .append(BLANK.getMessage())
                    .append(printVerticalBar(totalSize, index));
        }
        sb.append("]");
        System.out.println(sb);
    }

    private String printBridgeBlock(String userBridge, String bridgeLog, MoveKey moveKey) {
        if(userBridge.equals(moveKey.getMoveKey())) {
            return bridgeLog;
        }
        return BLANK.getMessage();
    }

    private String printVerticalBar(int totalSize, int index) {
        if(index < totalSize - 1) {
            return "|";
        }
        return "";
    }

    public void printResult() {
        System.out.println(Messages.FINAL_RESULT.getMessage());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Result result) {
        System.out.println(GAME_SUCCEED_OR_NOT_MSG.getMessage() + result.getGameResult());
        System.out.println(TOTAL_PRICE_MSG.getMessage() + result.getTotalTrial());
    }


}
