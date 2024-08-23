package bridge.view;

import bridge.model.AttemptCount;
import bridge.model.BridgeState;
import bridge.model.MoveResult;
import bridge.utils.enums.MoveCommend;

import java.util.ArrayList;
import java.util.List;

import static bridge.utils.enums.IOMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String CORRECT = "O";
    private static final String WRONG = "X";
    private static final String SPACE = " ";
    private static final String DIVIDER = " | ";
    private static final String OPEN = "[ ";
    private static final String CLOSE = " ]";

    public static void printGameStart() {
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(BridgeState bridgeState) {
        List<MoveResult> results = bridgeState.getMoveResults();
        List<String> upBridgeState = new ArrayList<>();
        List<String> downBridgeState = new ArrayList<>();
        for (MoveResult result : results) {
            String mark = result.isSuccess() ? CORRECT : WRONG;
            if (result.isEqualDirection(MoveCommend.UP)) {
                upBridgeState.add(mark);
                downBridgeState.add(SPACE);
            } else if (result.isEqualDirection(MoveCommend.DOWN)) {
                downBridgeState.add(mark);
                upBridgeState.add(SPACE);
            }
        }
        printFormattedBridge(upBridgeState, downBridgeState);
    }

    private static void printFormattedBridge(List<String> upBridgeState, List<String> downBridgeState) {
        String upResults = String.join(DIVIDER, upBridgeState);
        String downResults = String.join(DIVIDER, downBridgeState);
        System.out.println(OPEN + upResults + CLOSE);
        System.out.println(OPEN + downResults + CLOSE);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeState bridgeState, AttemptCount attemptCount, boolean isSuccess) {
        String successMessage = OUTPUT_FAIL.getMessage();
        if (isSuccess)
            successMessage = OUTPUT_SUCCESS.getMessage();
        System.out.println(OUTPUT_GAME_RESULT.getMessage());
        printMap(bridgeState);
        System.out.println(OUTPUT_SUCCESS_RESULT.getMessage() + successMessage);
        System.out.println(OUTPUT_ATTEMPT.getMessage() + attemptCount.getCount());
    }
}
