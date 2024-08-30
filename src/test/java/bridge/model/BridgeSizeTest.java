package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BridgeSizeTest {

    @DisplayName("다리 길이 3미만 테스트")
    @Test
    public void checkUnderSize() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BridgeSize(2));
    }

    @DisplayName("다리 길이 20 초과 테스트")
    @Test
    public void checkOverSize() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BridgeSize(30));
    }

}