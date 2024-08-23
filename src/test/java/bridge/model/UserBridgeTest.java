package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserBridgeTest {

    @DisplayName("다리 건너기 게임을 위한 사용자의 다리에 새로운 다리 조각을 추가한다.")
    @Test
    void addBridgeSegment() {
        // given
        UserBridge userBridge = new UserBridge();

        // when
        userBridge.addBridgeSegment("U");

        // then
        assertThat(userBridge.size()).isEqualTo(1);
    }

    @DisplayName("사용자의 입력 커맨드가 U 또는 D가 아닌 경우 예외를 발생시킨다.")
    @Test
    void addBridgeSegmentWithInvalidCommand() {
        // given
        UserBridge userBridge = new UserBridge();

        // when, then
        assertThatIllegalArgumentException().isThrownBy(() -> userBridge.addBridgeSegment("A"));
    }

    @DisplayName("다리 건너기 게임을 위한 사용자의 다리를 초기화한다.")
    @Test
    void resetUserBridge() {
        // given
        UserBridge userBridge = new UserBridge();
        userBridge.addBridgeSegment("U");
        userBridge.addBridgeSegment("D");

        // when
        userBridge.resetUserBridge();

        // then
        assertThat(userBridge.size()).isEqualTo(0);
    }
}
