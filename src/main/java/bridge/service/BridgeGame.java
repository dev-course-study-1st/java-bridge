package bridge.service;

import bridge.model.Bridge;
import bridge.model.BridgeLength;
import bridge.model.Result;
import bridge.model.SystemBridge;
import bridge.util.constant.GameResult;
import bridge.util.constant.MoveKey;
import bridge.util.constant.Numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final String O_MARK = "O";
    private final String X_MARK = "X";
    private final int INITIAL_TRIAL = 0;
    private final Bridge system;

    private final Bridge user;
    private int totalTrial = INITIAL_TRIAL;


    public BridgeGame(BridgeLength bridgeLength) {
        this.system = new SystemBridge(bridgeLength);
        this.user = new Bridge(new ArrayList<>());
        totalTrial++;
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(MoveKey moveKey) {
        user.add(moveKey);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        user.clear();
        totalTrial++;
    }

    public List<String> getUserBridge() {
        return List.copyOf(user.getBridge());
    }

    public List<String> getBridgeLog() {
        List<String> log = new ArrayList<>();
        for(int round = Numbers.BRIDGE_START.getNumber(); round < user.size(); round++) {
            log.add(getOorXMark(round));
        }
        return log;
    }

    private String getOorXMark(int round) {
        if(isCorrect(round)) {
            return O_MARK;
        }
        return X_MARK;
    }

    private boolean isCorrect(int round) {
        return system.get(round).equals(user.get(round));
    }

    public boolean isGameCompleted() {
        List<String> systemBridge = system.getBridge();
        List<String> userBridge = user.getBridge();
        return systemBridge.equals(userBridge);
    }

    public boolean isGameOver() {
        for (int index = 0; index < user.size(); index++) {
            if (!isCorrect(index)) {
                return true;
            }
        }
        return false;
    }

    public Result getResult() {
        return new Result(totalTrial, GameResult.getGameResult(isGameCompleted()));
    }
}
