package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RestartCommandTest {

    @Test
    @DisplayName("findByInput 메서드가 R 입력 시 RESTART 명령을 반환하는지 테스트")
    void findByInputShouldReturnRestartWhenInputIsR() {
        // Given
        String input = "R";

        // When
        RestartCommand result = RestartCommand.findByInput(input);

        // Then
        assertThat(result).isEqualTo(RestartCommand.RESTART);
    }

    @Test
    @DisplayName("findByInput 메서드가 Q 입력 시 QUIT 명령을 반환하는지 테스트")
    void findByInputShouldReturnQuitWhenInputIsQ() {
        // Given
        String input = "Q";

        // When
        RestartCommand result = RestartCommand.findByInput(input);

        // Then
        assertThat(result).isEqualTo(RestartCommand.QUIT);
    }

    @Test
    @DisplayName("findByInput 메서드가 유효하지 않은 입력 시 예외를 발생시키는지 테스트")
    void findByInputShouldThrowExceptionWhenInputIsInvalid() {
        // Given
        String invalidInput = "X";

        // When & Then
        assertThatThrownBy(() -> RestartCommand.findByInput(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("R 이나 Q를 입력해주세요.");
    }

    @Test
    @DisplayName("isQuitGame 메서드가 QUIT 명령어일 때 true를 반환하는지 테스트")
    void isQuitGameShouldReturnTrueWhenCommandIsQuit() {
        // Given
        RestartCommand command = RestartCommand.QUIT;

        // When
        boolean result = command.isQuitGame();

        // Then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("isQuitGame 메서드가 RESTART 명령어일 때 false를 반환하는지 테스트")
    void isQuitGameShouldReturnFalseWhenCommandIsRestart() {
        // Given
        RestartCommand command = RestartCommand.RESTART;

        // When
        boolean result = command.isQuitGame();

        // Then
        assertThat(result).isFalse();
    }
}
