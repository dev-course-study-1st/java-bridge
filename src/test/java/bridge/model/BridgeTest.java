package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BridgeTest {

    @DisplayName("Bridge의 길이가 20 이상 경우 객체 IllegalArgumentException 발생")
    @Test
    void 다리의_길이가_20_이상인_경우_예외발생() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Bridge(List.of("U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U")));
    }


    @DisplayName("Bridge의 길이가 3미만 인 경우 IllegalArugmentException 발생")
    @Test
    void 다리의_길이가_3_미만인_경우_예외발생() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Bridge(List.of("U", "D")));
    }

    @DisplayName("Bridge의 형태가 U 또는 D가 아닌 경우 IllegalArugmentException 발생")
    @ParameterizedTest
    @CsvSource(value = {"U, D, A", "U, U, 1"})
    void bridgeSegmentTest(String segment1, String segment2, String segment3) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Bridge(List.of(segment1, segment2, segment3)));
    }

    @DisplayName("다리의 길이가 3 이상 20 이하이고, 형태가 U 또는 D인 경우 객체 생성")
    @Test
    void createBridge() {
        assertThatCode(() -> new Bridge(List.of("U", "D", "U", "U"))).doesNotThrowAnyException();
    }

    @DisplayName("다리의 입력 위치의 값과 입력 커맨드가 같다면")
    @Test
    void canMoveIsReturnTrue() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "U", "U"));

        // when & then
        assertThat(bridge.isMove(0, "U")).isTrue();
        assertThat(bridge.isMove(1, "D")).isTrue();
        assertThat(bridge.isMove(2, "U")).isTrue();
        assertThat(bridge.isMove(3, "U")).isTrue();
    }

    @DisplayName("다리의 입력위치의 값과 입력 커맨드가 일치 하지 않을 경우 false를 반환한다")
    @Test
    void cannotMoveIsReturnFalse() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "U", "U"));

        // when & then
        assertThat(bridge.isMove(0, "D")).isFalse();
        assertThat(bridge.isMove(1, "U")).isFalse();
        assertThat(bridge.isMove(2, "D")).isFalse();
        assertThat(bridge.isMove(3, "D")).isFalse();
    }

    @DisplayName("다리의 길이가 현재 위치랑 같을 경우 true를 반환한다")
    @Test
    void isEndOfBridge() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "U", "U"));

        // when & then
        assertThat(bridge.isEndOfBridge(4)).isTrue();
    }

    @DisplayName("다리의 길이가 현재 위치랑 다를 경우 false를 반환한다")
    @Test
    void isNotEndOfBridge() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "U", "U"));

        // when & then
        assertThat(bridge.isEndOfBridge(3)).isFalse();
    }

}
