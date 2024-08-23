package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;
import static org.assertj.core.api.Assertions.*;

public class BridgeMakerTest {

    @DisplayName("다리의 길이에 해당하는 다리를 생성한다.")
    @Test
    void makeBridge() {
        // given
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        int size = 5;

        // when
        List<String> bridge = bridgeMaker.makeBridge(size);

        // then
        assertThat(bridge.size()).isEqualTo(size);
    }

    @DisplayName("BridgeNumberGenerator 에서 0이 생성되면 D 모양의 다리를 생성한다.")
    @Test
    void makeBridgeWithDown() {
        // given
        BridgeNumberGenerator bridgeNumberGenerator = () -> 0;
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        int size = 5;

        // when
        List<String> bridge = bridgeMaker.makeBridge(size);

        // then
        assertThat(bridge).isEqualTo(newArrayList("D", "D", "D", "D", "D"));
    }

    @DisplayName("BridgeNumberGenerator 에서 1이 생성되면 U 모양의 다리를 생성한다.")
    @Test
    void makeBridgeWithUp() {
        // given
        BridgeNumberGenerator bridgeNumberGenerator = () -> 0;
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        int size = 5;

        // when
        List<String> bridge = bridgeMaker.makeBridge(size);

        // then
        assertThat(bridge).isEqualTo(newArrayList("D", "D", "D", "D", "D"));
    }

    @DisplayName("BridgeNumberGenerator 에서 0 또는 1이 아닌 수가 나오면 예외를 발생한다.")
    @Test
    void makeBridgeWithInvalidNumber() {
        // given
        BridgeNumberGenerator bridgeNumberGenerator = () -> 2;
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        int size = 5;

        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> bridgeMaker.makeBridge(size));
    }
}
