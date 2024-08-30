package bridge.model;

import bridge.utils.generator.BridgeNumberGenerator;
import bridge.utils.generator.OneNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class BridgeGameTest {
    private BridgeGame bridgeGame;
    private BridgeSize bridgeSize;
    private BridgeMaker bridgeMaker;
    private BridgeNumberGenerator bridgeNumberGenerator;

    @BeforeEach
    void setUp() {
        // Up만 생성
        bridgeNumberGenerator = new OneNumberGenerator();
        bridgeSize = new BridgeSize(3);
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridgeGame = new BridgeGame(bridgeSize, bridgeMaker);
    }

    @DisplayName("이동 성공 테스트")
    @Test
    void checkMoveSuccess() {
        MoveResult moveResult = bridgeGame.move("U");
        assertThat(moveResult.isSuccess()).isTrue();
    }

    @DisplayName("이동 실패 테스트")
    @Test
    void checkMoveFail() {
        MoveResult moveResult = bridgeGame.move("D");
        assertThat(moveResult.isSuccess()).isFalse();
    }

    @DisplayName("마지막 도달 성공 테스트")
    @Test
    void checkSuccessEndOfBridge() {
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("U");
        assertThat(bridgeGame.isBridgeEndReached()).isTrue();
    }

    @DisplayName("마지막 도달 실패 테스트")
    @Test
    void checkFailEndOfBridge() {
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("D");
        assertThat(bridgeGame.isBridgeEndReached()).isFalse();
    }

}