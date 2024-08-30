package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeSizeTest {

    @Test
    @DisplayName("다리 길이가 유효 범위(3~20) 내에 있을 때 객체가 정상적으로 생성되는지 테스트")
    void shouldCreateBridgeSizeWhenValueIsValid() {
        // Given
        int validValue = 10;

        // When
        BridgeSize bridgeSize = new BridgeSize(validValue);

        // Then
        assertThat(bridgeSize.getValue()).isEqualTo(validValue);
    }

    @Test
    @DisplayName("다리 길이가 유효 범위(3~20)를 벗어났을 때 예외가 발생하는지 테스트")
    void shouldThrowExceptionWhenValueIsOutOfRange() {
        // Given
        int invalidValueBelowRange = 2;
        int invalidValueAboveRange = 21;

        // When & Then
        assertThatThrownBy(() -> new BridgeSize(invalidValueBelowRange))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("다리 길이는 3부터 20 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> new BridgeSize(invalidValueAboveRange))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("getValue 메서드가 올바른 값을 반환하는지 테스트")
    void getValueShouldReturnCorrectValue() {
        // Given
        int validValue = 15;
        BridgeSize bridgeSize = new BridgeSize(validValue);

        // When
        int result = bridgeSize.getValue();

        // Then
        assertThat(result).isEqualTo(validValue);
    }
}

