package bridge.model;

import bridge.utils.enums.MoveCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {
    private Bridge bridge;

    @BeforeEach
    void setUp() {
        bridge = new Bridge(List.of("U", "D", "U"));
    }

    @DisplayName("다리 방향 리스트 반환 테스트")
    @Test
    void checkBridgeDirections() {
        assertThat(bridge.getBridge()).isEqualTo(List.of("U", "D", "U"));
    }

    @DisplayName("다리 사이즈 반환 테스트")
    @Test
    void checkBridgeSize() {
        assertThat(bridge.getSize()).isEqualTo(3);
    }

    @DisplayName("다리 방향 체크 테스트")
    @Test
    void checkDirection() {
        assertThat(bridge.isRightDirection(new Position(), MoveCommand.UP)).isTrue();
    }
}