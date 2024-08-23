package bridge.service;

import bridge.model.AttemptCount;
import bridge.model.Bridge;
import bridge.model.MoveResult;
import bridge.model.Position;
import bridge.utils.enums.MoveCommend;

import static bridge.utils.enums.Const.*;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private Position currentPosition;
    private AttemptCount attemptCount;

    public BridgeGame(Bridge bridge){
        this.bridge = bridge;
        this.currentPosition = new Position(BRIDGE_INIT_NUMBER.getNumber());
        this.attemptCount = new AttemptCount(ATTEMPT_INIT_NUMBER.getNumber());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MoveResult move(String moveCommend) {
        MoveCommend direction = MoveCommend.valueOf(moveCommend);
        boolean success = false;
        if (direction.isEqualTo(bridge.getDirection(currentPosition))) {
            currentPosition.increment();
            success = true;
        }
        return new MoveResult(success, direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        currentPosition = new Position(BRIDGE_INIT_NUMBER.getNumber());
        attemptCount.increment();
    }
}
