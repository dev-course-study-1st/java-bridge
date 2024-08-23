package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

public class BridgeTest {

    @Test
    @DisplayName("canGo 메서드가 인덱스와 값이 일치할 때 true를 반환하는지 테스트")
    void canGo_shouldReturnTrueWhenValuesMatch() {
        // Given
        List<String> values = Arrays.asList("A", "B", "C");
        Bridge bridge = new Bridge(values);

        // When & Then
        assertThat(bridge.canGo(0, "A")).isTrue();
        assertThat(bridge.canGo(1, "B")).isTrue();
        assertThat(bridge.canGo(2, "C")).isTrue();
    }

    @Test
    @DisplayName("canGo 메서드가 인덱스와 값이 일치하지 않을 때 false를 반환하는지 테스트")
    void canGo_shouldReturnFalseWhenValuesDoNotMatch() {
        // Given
        List<String> values = Arrays.asList("A", "B", "C");
        Bridge bridge = new Bridge(values);

        // When & Then
        assertThat(bridge.canGo(0, "B")).isFalse();
        assertThat(bridge.canGo(1, "C")).isFalse();
        assertThat(bridge.canGo(2, "A")).isFalse();
    }

    @Test
    @DisplayName("getValue 메서드가 올바른 값을 반환하는지 테스트")
    void getValue_shouldReturnCorrectList() {
        // Given
        List<String> values = Arrays.asList("A", "B", "C");
        Bridge bridge = new Bridge(values);

        // When
        List<String> result = bridge.getValue();

        // Then
        assertThat(result).containsExactly("A", "B", "C");
    }
}

