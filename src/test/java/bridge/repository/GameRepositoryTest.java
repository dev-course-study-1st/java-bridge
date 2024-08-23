package bridge.repository;

import bridge.domain.Bridge;
import bridge.domain.MovingCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GameRepositoryTest {

    private GameRepository gameRepository;
    private Bridge bridge;

    @BeforeEach
    void setUp() {
        gameRepository = new GameRepository();
        bridge = new Bridge(Arrays.asList("U", "D", "U"));
    }

    @Test
    @DisplayName("save 메서드가 다리 객체를 저장하는지 테스트")
    void saveShouldStoreBridge() {
        // When
        gameRepository.save(bridge);

        // Then
        assertThat(gameRepository.getBridge()).isEqualTo(bridge);
    }

    @Test
    @DisplayName("addAttempts 메서드가 시도 횟수를 증가시키는지 테스트")
    void addAttemptsShouldIncreaseTryCount() {
        // When
        gameRepository.addAttempts();
        gameRepository.addAttempts();

        // Then
        assertThat(gameRepository.getAttempts()).isEqualTo(3); // FIRST_TRY의 기본값이 1이라고 가정
    }

    @Test
    @DisplayName("setIsSuccessInGame 메서드가 성공 상태를 설정하는지 테스트")
    void setIsSuccessInGameShouldSetSuccessStatus() {
        // When
        gameRepository.setIsSuccessInGame();

        // Then
        assertThat(gameRepository.getIsSuccessInGame()).isTrue();
    }

    @Test
    @DisplayName("isGo 메서드가 올바른 이동 명령에 대해 true를 반환하는지 테스트")
    void isGoShouldReturnTrueForCorrectMove() {
        // Given
        gameRepository.save(bridge);

        // When & Then
        assertThat(gameRepository.isGo(0, MovingCommand.UP)).isTrue();
        assertThat(gameRepository.isGo(1, MovingCommand.DOWN)).isTrue();
    }

    @Test
    @DisplayName("isGo 메서드가 잘못된 이동 명령에 대해 false를 반환하는지 테스트")
    void isGoShouldReturnFalseForIncorrectMove() {
        // Given
        gameRepository.save(bridge);

        // When & Then
        assertThat(gameRepository.isGo(0, MovingCommand.DOWN)).isFalse();
        assertThat(gameRepository.isGo(1, MovingCommand.UP)).isFalse();
    }

    @Test
    @DisplayName("getSize 메서드가 다리의 크기를 올바르게 반환하는지 테스트")
    void getSizeShouldReturnBridgeSize() {
        // Given
        gameRepository.save(bridge);

        // When
        int size = gameRepository.getSize();

        // Then
        assertThat(size).isEqualTo(3);
    }
}
