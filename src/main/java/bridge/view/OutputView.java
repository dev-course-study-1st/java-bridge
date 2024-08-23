package bridge.view;

import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> userBridge, List<String> gameBridge) {
        System.out.println(createBridge(userBridge,gameBridge));
    }

    // TODO : 현재 너무 복잡하게 사용되고 있음, 한가지 기능만을 하도록 변경
    private String createBridge(List<String> userBridge, List<String> gameBridge) {
        // 여기서 userBridge 와 gameBridge를 비교한다.
        // index가 같을 때 같은 문자열이면 O를 출력 아니면 X를 출력
        StringJoiner bridge = new StringJoiner("\n");

        StringJoiner upBridge = new StringJoiner(" | ");
        StringJoiner downBridge = new StringJoiner(" | ");

        for(int i=0; i<userBridge.size(); i++) {
            if (userBridge.get(i).equals(gameBridge.get(i))) {
                if (userBridge.get(i).equals("U")) {
                    upBridge.add("O");
                    downBridge.add(" ");
                }
                if (userBridge.get(i).equals("D")) {
                    upBridge.add(" ");
                    downBridge.add("O");
                }
            }
            if (!userBridge.get(i).equals(gameBridge.get(i))) {
                if (userBridge.get(i).equals("U")) {
                    upBridge.add("X");
                    downBridge.add(" ");
                }
                if (userBridge.get(i).equals("D")) {
                    upBridge.add(" ");
                    downBridge.add("X");
                }
            }
        }
        return bridge.add(String.format("[ %s ]", upBridge)).add(String.format("[ %s ]", downBridge)).toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isGameEnd, int tryCount) {
        System.out.println(GameMessage.OUTPUT_END_MESSAGE.getMessage());
        System.out.printf(GameMessage.OUTPUT_GAME_RESULT.getMessage(),isGameEndStatusToString(isGameEnd));
        System.out.printf(GameMessage.OUTPUT_TOTAL_COUNT.getMessage(),tryCount);
    }

    public void initGame() {
        System.out.println(GameMessage.OUTPUT_INIT_MESSAGE.getMessage());
    }

    public void printErrorMessage(String message) {
        System.out.printf(GameMessage.OUTPUT_ERROR_MESSAGE.getMessage(),message);
    }

    private String isGameEndStatusToString(boolean isGameEnd) {
        if(isGameEnd) {
            return GameMessage.GAME_SUCCESS.getMessage();
        }
        return GameMessage.GAME_FAIL.getMessage();
    }
}
