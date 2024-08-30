package bridge.service;

import bridge.model.BridgeMaker;
import bridge.model.BridgeSize;
import bridge.model.BridgeState;
import bridge.utils.generator.BridgeNumberGenerator;
import bridge.utils.generator.OneNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameServiceTest {
    private BridgeMaker bridgeMaker;
    private BridgeNumberGenerator bridgeNumberGenerator;
    private BridgeSize bridgeSize;
    private BridgeGameService bridgeGameService;

    @BeforeEach
    void setUp() {
        // UP만 생성
        bridgeNumberGenerator = new OneNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridgeSize = new BridgeSize(3);
        bridgeGameService = new BridgeGameService(bridgeMaker, new BridgeState());
        bridgeGameService.initializeGame(bridgeSize);
    }

    @DisplayName("이동 성공 테스트")
    @Test
    void checkMoveSuccess() {
        bridgeGameService.move("U");
        BridgeState bridgeState = bridgeGameService.getBridgeState();
        assertThat(bridgeState.isSuccess()).isTrue();
    }

    @DisplayName("이동 실패 테스트")
    @Test
    void checkMoveFail() {
        bridgeGameService.move("D");
        BridgeState bridgeState = bridgeGameService.getBridgeState();
        assertThat(bridgeState.isSuccess()).isFalse();
    }

    @DisplayName("재시작 테스트")
    @Test
    void checkRetry() {
        bridgeGameService.move("U");
        boolean retry = bridgeGameService.retry("R");
        BridgeState bridgeState = bridgeGameService.getBridgeState();
        assertThat(retry).isTrue();
        assertThat(bridgeState.getMoveResults()).isEmpty();
    }

    @DisplayName("게임 종료 테스트")
    @Test
    void checkQuit() {
        bridgeGameService.move("U");
        boolean retry = bridgeGameService.retry("Q");
        BridgeState bridgeState = bridgeGameService.getBridgeState();
        assertThat(retry).isFalse();
        assertThat(bridgeState.getMoveResults()).isNotEmpty();
    }

    @DisplayName("현재까지 이동 성공했지만 게임이 안끝난 경우 테스트")
    @Test
    void checkCurrentSuccess() {
        bridgeGameService.move("U");
        bridgeGameService.move("U");
        assertThat(bridgeGameService.isGameSuccess()).isTrue();
        assertThat(bridgeGameService.isGameWon()).isFalse();
    }

    @DisplayName("게임 승리 테스트")
    @Test
    void checkGameWon() {
        bridgeGameService.move("U");
        bridgeGameService.move("U");
        bridgeGameService.move("U");
        assertThat(bridgeGameService.isGameSuccess()).isTrue();
        assertThat(bridgeGameService.isGameWon()).isTrue();
    }

    @DisplayName("게임 실패 테스트")
    @Test
    void checkGameFail() {
        bridgeGameService.move("U");
        bridgeGameService.move("U");
        bridgeGameService.move("D");
        assertThat(bridgeGameService.isGameSuccess()).isFalse();
        assertThat(bridgeGameService.isGameWon()).isFalse();
    }

}