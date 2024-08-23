package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MovingCommandTest {

    @Test
    @DisplayName("findByInput 메서드가 U 입력 시 UP 명령을 반환하는지 테스트")
    void findByInputShouldReturnUpWhenInputIsU() {
        // Given
        String input = "U";

        // When
        MovingCommand result = MovingCommand.findByInput(input);

        // Then
        assertThat(result).isEqualTo(MovingCommand.UP);
    }

    @Test
    @DisplayName("findByInput 메서드가 D 입력 시 DOWN 명령을 반환하는지 테스트")
    void findByInputShouldReturnDownWhenInputIsD() {
        // Given
        String input = "D";

        // When
        MovingCommand result = MovingCommand.findByInput(input);

        // Then
        assertThat(result).isEqualTo(MovingCommand.DOWN);
    }

    @Test
    @DisplayName("findByInput 메서드가 유효하지 않은 입력 시 예외를 발생시키는지 테스트")
    void findByInputShouldThrowExceptionWhenInputIsInvalid() {
        // Given
        String invalidInput = "X";

        // When & Then
        assertThatThrownBy(() -> MovingCommand.findByInput(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("U 나 D를 입력해주세요.");
    }

    @Test
    @DisplayName("getValue 메서드가 올바른 값을 반환하는지 테스트")
    void getValueShouldReturnCorrectValue() {
        // When & Then
        assertThat(MovingCommand.UP.getValue()).isEqualTo("U");
        assertThat(MovingCommand.DOWN.getValue()).isEqualTo("D");
    }
}
