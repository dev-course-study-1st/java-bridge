package bridge.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    private Position position;

    @BeforeEach
    void setUp() {
        position = new Position();

    }

    @DisplayName("현재 위치 생성 초기값 테스트")
    @Test
    void checkInitialPosition() {
        assertThat(position.getValue())
                .isEqualTo(0);
    }

    @DisplayName("위치 증가 테스트")
    @Test
    void checkIncrementPosition(){
        position.increment();
        assertThat(position.getValue())
                .isEqualTo(1);
    }

    @DisplayName("위치 리셋 테스트")
    @Test
    void checkClearPosition(){
        position.increment();
        position.reset();
        assertThat(position.getValue())
                .isEqualTo(0);
    }
}