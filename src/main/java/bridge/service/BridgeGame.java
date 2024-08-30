package bridge.service;

import bridge.model.Bridge;
import bridge.constant.RestartCommand;
import bridge.model.GameStatus;
import bridge.model.UserBridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final UserBridge userBridge;
    private final GameStatus gameStatus;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.userBridge = new UserBridge();
        this.gameStatus = new GameStatus();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String command) {
        if (!(isMove(command))) {
            gameStatus.failGame();
        }
    }

    private boolean isMove(String command) {
        int currentLocation = userBridge.size();
        userBridge.addBridgeSegment(command);
        return bridge.isMove(currentLocation, command);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String gameCommand) {
        if (isRetry(gameCommand)) {
            retryGame();
        }
    }

    private boolean isRetry(String command) {
        return RestartCommand.stringToCommand(command) == RestartCommand.RESTART;
    }

    private void retryGame() {
        userBridge.resetUserBridge();
        gameStatus.retryGame();
    }


    public void isGameEnd() {
        if (bridge.isEndOfBridge(userBridge.size())) {
            gameStatus.endGame();
        }
    }

    public UserBridge getUserBridge() {
        return userBridge;
    }

    public int getTryCount() {
        return gameStatus.getTryCount();
    }

    public boolean isRunning() {
        return gameStatus.isGameRunning();
    }

    public boolean isGameSuccess() {
        return gameStatus.isGameSuccess();
    }
}
