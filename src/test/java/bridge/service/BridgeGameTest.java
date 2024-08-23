package bridge.service;

import bridge.model.Bridge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BridgeGameTest {

    private Bridge bridge;

    @BeforeEach
    void setUp() {
        List<String> list = new ArrayList<>();
        list.add("U");
        list.add("U");
        list.add("U");

        bridge = new Bridge(list);
    }

    @DisplayName("다리게임이 시작되면 count를 1로 초기화한다.")
    @Test
    void startBridgeGame() {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        assertThat(bridgeGame.getTryCount()).isEqualTo(1);
    }

    @DisplayName("다리게임이 시작되면 사용자의 입력을 저장할 UserBridge를 초기화한다.")
    @Test
    void startBridgeGameWithUserBridge() {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        assertThat(bridgeGame.getUserBridge().size()).isEqualTo(0);
    }

    @DisplayName("이동입력을 받으면 사용자의 다리에 입력을 추가한다.")
    @Test
    void moveTest() {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");

        assertThat(bridgeGame.getUserBridge().size()).isEqualTo(1);
    }

    @DisplayName("이동입력을 받았을 때 입력이 다리의 다음 위치와 일치하면 true를 반환하고, 사용자 다리에 추가한다.")
    @Test
    void isMoveTest() {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        boolean result = bridgeGame.move("U");

        assertThat(result).isTrue();
        assertThat(bridgeGame.getUserBridge().size()).isEqualTo(1);
    }

    @DisplayName("이동입력을 받았을 때 입력이 다리의 다음 위치와 일치하지 않으면 false를 반환하고, 사용자 다리에 추가한다.")
    @Test
    void isNotMoveTest() {
        BridgeGame bridgeGame = new BridgeGame(bridge);

        assertThat(bridgeGame.move("D")).isFalse();
        assertThat(bridgeGame.getUserBridge().size()).isEqualTo(1);
    }

    @DisplayName("재시작 입력을 받으면 사용자의 다리를 초기화하고 시도 횟수를 증가시킨다.")
    @Test
    void retryTest() {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");
        bridgeGame.move("D");

        assertThat(bridgeGame.getTryCount()).isEqualTo(1);

        bridgeGame.retry("R");

        assertThat(bridgeGame.getTryCount()).isEqualTo(2);
        assertThat(bridgeGame.getUserBridge().size()).isEqualTo(0);
    }

    @DisplayName("재시작 입력이 R인 경우 true를 반환한다.")
    @Test
    void retryWithRestartCommand() {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");
        bridgeGame.move("D");

        assertThat(bridgeGame.retry("R")).isTrue();
    }

    @DisplayName("재시작 입력이 Q인 경우 false를 반환한다.")
    @Test
    void retryWithQuitCommand() {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");
        bridgeGame.move("D");

        assertThat(bridgeGame.retry("Q")).isFalse();
    }

    @DisplayName("재시작 입력이 R 또는 Q가 아닌 경우 예외를 발생시킨다.")
    @Test
    void retryWithInvalidCommand() {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");
        bridgeGame.move("D");

        assertThatIllegalArgumentException().isThrownBy(() -> bridgeGame.retry("A"));
    }

    @DisplayName("게임이 종료되면 true를 반환한다.")
    @Test
    void isGameEndTest() {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("U");

        assertThat(bridgeGame.isGameEnd()).isTrue();
    }
}
