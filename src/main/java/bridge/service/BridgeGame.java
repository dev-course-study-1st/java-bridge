package bridge.service;

import bridge.BridgeNumberGenerator;
import bridge.model.BridgeLength;
import bridge.model.BridgeMaker;
import bridge.model.Result;
import bridge.util.constant.GameResult;
import bridge.util.constant.MoveKey;
import bridge.util.constant.Numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final String O_MARK = "O";
    private final String X_MARK = "X";
    private final int INITIAL_TRIAL = 0;
    private final List<String> systemBridge;

    private List<String> userBridge;
    private int totalTrial = INITIAL_TRIAL;


    public BridgeGame(BridgeNumberGenerator generator, BridgeLength bridgeLength) {
        this.systemBridge = makeBridge(generator, bridgeLength);
        System.out.println("systemBridge = " + systemBridge);
        this.userBridge = new ArrayList<>();
        totalTrial++;
    }

    private List<String> makeBridge(BridgeNumberGenerator generator, BridgeLength bridgeLength) {
        final BridgeMaker bridgeMaker = new BridgeMaker(generator);
        return bridgeMaker.makeBridge(bridgeLength.getLength());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(MoveKey moveKey) {
        userBridge.add(moveKey.getMoveKey());
        System.out.println("userBridge = " + userBridge);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        userBridge = new ArrayList<>();
        totalTrial++;
    }

    public List<String> getUserBridge() {
        return List.copyOf(userBridge);
    }

    public List<String> getBridgeLog() {
        List<String> log = new ArrayList<>();
        for(int round = Numbers.BRIDGE_START.getNumber(); round < userBridge.size(); round++) {
            log.add(getOorXMark(round));
        }
        return log;
    }

    private String getOorXMark(int round) {
        if(systemBridge.get(round).equals(userBridge.get(round))) {
            return O_MARK;
        }
        return X_MARK;
    }

    public boolean isGameCompleted() {
        return systemBridge.equals(userBridge);
    }

    public boolean isGameOver() {
        List<String> subList = systemBridge.subList(Numbers.BRIDGE_START.getNumber(), userBridge.size());
        return !Objects.equals(subList, userBridge);
    }

    public Result getResult() {
        return new Result(totalTrial, GameResult.getGameResult(isGameCompleted()));
    }
}
