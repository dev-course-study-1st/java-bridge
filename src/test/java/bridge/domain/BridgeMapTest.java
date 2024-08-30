package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

public class BridgeMapTest {

    @Test
    @DisplayName("UP 명령어로 맵을 업데이트할 때 upperMap에 값이 추가되고 lowerMap에 공백이 추가되는지 테스트")
    void updateMapShouldUpdateUpperMapWhenMovingUp() {
        // Given
        BridgeMap bridgeMap = new BridgeMap();

        // When
        bridgeMap.updateMap(MovingCommand.UP, RoundStatus.ROUND_CONTINUE);

        // Then
        assertThat(bridgeMap.getUpperMap()).containsExactly(RoundStatus.ROUND_CONTINUE.getValue());
        assertThat(bridgeMap.getLowerMap()).containsExactly(RoundStatus.SPACE.getValue());
    }

    @Test
    @DisplayName("DOWN 명령어로 맵을 업데이트할 때 lowerMap에 값이 추가되고 upperMap에 공백이 추가되는지 테스트")
    void updateMapShouldUpdateLowerMapWhenMovingDown() {
        // Given
        BridgeMap bridgeMap = new BridgeMap();

        // When
        bridgeMap.updateMap(MovingCommand.DOWN, RoundStatus.ROUND_END);

        // Then
        assertThat(bridgeMap.getUpperMap()).containsExactly(RoundStatus.SPACE.getValue());
        assertThat(bridgeMap.getLowerMap()).containsExactly(RoundStatus.ROUND_END.getValue());
    }

    @Test
    @DisplayName("reset 메서드가 upperMap과 lowerMap을 초기화하는지 테스트")
    void resetShouldClearBothMaps() {
        // Given
        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.updateMap(MovingCommand.UP, RoundStatus.ROUND_CONTINUE);
        bridgeMap.updateMap(MovingCommand.DOWN, RoundStatus.ROUND_END);

        // When
        bridgeMap.reset();

        // Then
        assertThat(bridgeMap.getUpperMap()).isEmpty();
        assertThat(bridgeMap.getLowerMap()).isEmpty();
    }

    @Test
    @DisplayName("getUpperMap과 getLowerMap 메서드가 올바른 값을 반환하는지 테스트")
    void getUpperMapAndLowerMapShouldReturnCorrectValues() {
        // Given
        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.updateMap(MovingCommand.UP, RoundStatus.ROUND_CONTINUE);
        bridgeMap.updateMap(MovingCommand.DOWN, RoundStatus.ROUND_END);

        // When
        List<String> upperMap = bridgeMap.getUpperMap();
        List<String> lowerMap = bridgeMap.getLowerMap();

        // Then
        assertThat(upperMap).containsExactly(RoundStatus.ROUND_CONTINUE.getValue(), RoundStatus.SPACE.getValue());
        assertThat(lowerMap).containsExactly(RoundStatus.SPACE.getValue(), RoundStatus.ROUND_END.getValue());
    }
}
