package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {

    @Test
    @DisplayName("ZeroNumberGenerator를 사용하여 다리를 생성할 때, 모든 값이 DOWN인지 테스트")
    void makeBridgeShouldReturnAllDownWithZeroNumberGenerator() {
        // Given
        BridgeNumberGenerator generator = () -> 0;
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        int bridgeSize = 3;

        // When
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        // Then
        assertThat(bridge).containsExactly("D", "D", "D");
    }

    @Test
    @DisplayName("OneNumberGenerator를 사용하여 다리를 생성할 때, 모든 값이 UP인지 테스트")
    void makeBridgeShouldReturnAllUpWithOneNumberGenerator() {
        // Given
        BridgeNumberGenerator generator = () -> 1;
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        int bridgeSize = 3;

        // When
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        // Then
        assertThat(bridge).containsExactly("U", "U", "U");
    }
}
