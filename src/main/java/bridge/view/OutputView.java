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
        System.out.println("최종 게임 결과");
        System.out.println("게임 성공 여부: " + (isGameEnd ? "성공" : "실패"));
        System.out.println("총 시도한 횟수: " + tryCount);
    }

    public void initGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
}
