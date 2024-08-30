package bridge.model;

import bridge.utils.enums.MoveCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeStateTest {
    private BridgeState bridgeState;

    @BeforeEach
    void setUp(){
        bridgeState = new BridgeState();
    }

    @DisplayName("이동 결과 추가 테스트")
    @Test
    void checkAddMoveResult(){
        MoveResult moveResult = new MoveResult(true, MoveCommand.UP);
        bridgeState.addMoveResult(moveResult);
        assertThat(bridgeState.getMoveResults()).containsExactly(moveResult);
    }

    @DisplayName("이동 결과 리스트 반환 테스트")
    @Test
    void checkGetMoveResults(){
        MoveResult moveResult1 = new MoveResult(true, MoveCommand.UP);
        MoveResult moveResult2 = new MoveResult(false, MoveCommand.DOWN);
        bridgeState.addMoveResult(moveResult1);
        bridgeState.addMoveResult(moveResult2);
        assertThat(bridgeState.getMoveResults()).containsExactly(moveResult1, moveResult2);
    }

    @DisplayName("클리어 테스트")
    @Test
    void checkClear(){
        MoveResult moveResult = new MoveResult(true, MoveCommand.UP);
        bridgeState.clear();
        assertThat(bridgeState.getMoveResults()).isEmpty();
    }

    @DisplayName("모두 성공 테스트")
    @Test
    void checkSuccess(){
        MoveResult moveResult1 = new MoveResult(true, MoveCommand.UP);
        MoveResult moveResult2 = new MoveResult(true, MoveCommand.DOWN);
        bridgeState.addMoveResult(moveResult1);
        bridgeState.addMoveResult(moveResult2);
        assertThat(bridgeState.isSuccess()).isTrue();
    }

    @DisplayName("하나 실패 테스트")
    @Test
    void checkOneFail(){
        MoveResult moveResult1 = new MoveResult(true, MoveCommand.UP);
        MoveResult moveResult2 = new MoveResult(false, MoveCommand.DOWN);
        bridgeState.addMoveResult(moveResult1);
        bridgeState.addMoveResult(moveResult2);
        assertThat(bridgeState.isSuccess()).isFalse();
    }

}