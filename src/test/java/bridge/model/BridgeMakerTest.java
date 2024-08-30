package bridge.model;

import bridge.utils.generator.BridgeRandomNumberGenerator;
import bridge.utils.generator.OneNumberGenerator;
import bridge.utils.generator.ZeroNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {
    private BridgeMaker bridgeMaker;

    @DisplayName("0이면 D방향 테스트")
    @Test
    void checkDownList() {
        bridgeMaker = new BridgeMaker(new ZeroNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsOnly("D");
    }

    @DisplayName("1이면 U방향 테스트")
    @Test
    void checkUpList() {
        bridgeMaker = new BridgeMaker(new OneNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsOnly("U");
    }

    @DisplayName("U방향 또는 D방향 포함 테스트")
    @Test
    void checkOnlyUpOrDown() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(5);
        assertThat(bridge).containsOnly("U", "D");
    }

}