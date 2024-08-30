package bridge.model;

import bridge.utils.enums.MoveCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveResultTest {
    @DisplayName("이동 결과 U 비교 테스트")
    @Test
    void checkUpResult() {
        MoveResult moveResult = new MoveResult(true, MoveCommand.UP);
        assertThat(moveResult.isEqualDirection(MoveCommand.UP))
                .isTrue();
    }

    @DisplayName(("이동 결과 D 비교 테스트"))
    @Test
    void checkDownResult() {
        MoveResult moveResult = new MoveResult(true, MoveCommand.DOWN);
        assertThat(moveResult.isEqualDirection(MoveCommand.DOWN))
                .isTrue();
    }

    @DisplayName("이동 맞췄을때 테스트")
    @Test
    void checkCorrectResult(){
        MoveResult moveResult = new MoveResult(true, MoveCommand.UP);
        assertThat(moveResult.isSuccess()).isTrue();
    }

    @DisplayName("이동 틀렸을때 테스트")
    @Test
    void checkWrongResult(){
        MoveResult moveResult = new MoveResult(false, MoveCommand.UP);
        assertThat(moveResult.isSuccess()).isFalse();
    }
}