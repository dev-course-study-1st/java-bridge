package bridge.model;

import bridge.utils.enums.MoveCommand;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final Position currentPosition;

    public BridgeGame(BridgeSize bridgeSize, BridgeMaker bridgeMaker) {
        this.bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize.getValue()));
        this.currentPosition = new Position();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MoveResult move(String moveCommand) {
        MoveCommand direction = MoveCommand.fromString(moveCommand);
        boolean success = false;
        if (bridge.isRightDirection(currentPosition, direction)) {
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
        currentPosition.reset();
    }

    public boolean isGameComplete() {
        return currentPosition.getValue() == bridge.getSize();
    }
}
