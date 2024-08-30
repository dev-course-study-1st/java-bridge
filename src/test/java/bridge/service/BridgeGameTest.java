//package bridge.service;
//
//import bridge.BridgeMaker;
//import bridge.BridgeNumberGenerator;
//import bridge.domain.BridgeMap;
//import bridge.domain.GameResult;
//import bridge.domain.MovingCommand;
//import bridge.domain.RoundStatus;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class BridgeGameTest {
//
//    private BridgeMap bridgeMap;
//    private BridgeMaker bridgeMaker;
//    private BridgeGame bridgeGame;
//
//    @BeforeEach
//    void setUp() {
//        bridgeMap = new BridgeMap();
//    }
//
//    @Test
//    @DisplayName("ZeroNumberGenerator를 사용하여 다리를 생성하고 저장하는지 테스트")
//    void makeBridgeWithZeroNumberGeneratorShouldCreateAndSaveBridge() {
//        // Given
//        BridgeNumberGenerator zeroGenerator = () -> 0;
//        bridgeMaker = new BridgeMaker(zeroGenerator);
//        bridgeGame = new BridgeGame(gameRepository, bridgeMap, bridgeMaker);
//
//        // When
//        bridgeGame.makeBridge(3);
//
//        // Then
//        assertThat(gameRepository.getBridge().getValue()).containsExactly("D", "D", "D");
//    }
//
//    @Test
//    @DisplayName("OneNumberGenerator를 사용하여 다리를 생성하고 저장하는지 테스트")
//    void makeBridgeWithOneNumberGeneratorShouldCreateAndSaveBridge() {
//        // Given
//        BridgeNumberGenerator oneGenerator = () -> 1;
//        bridgeMaker = new BridgeMaker(oneGenerator);
//        bridgeGame = new BridgeGame(gameRepository, bridgeMap, bridgeMaker);
//
//        // When
//        bridgeGame.makeBridge(3);
//
//        // Then
//        assertThat(gameRepository.getBridge().getValue()).containsExactly("U", "U", "U");
//    }
//
//    @Test
//    @DisplayName("move 메서드가 올바르게 맵을 업데이트하는지 테스트")
//    void moveShouldUpdateBridgeMapCorrectly() {
//        // Given
//        BridgeNumberGenerator oneGenerator = () -> 1;
//        bridgeMaker = new BridgeMaker(oneGenerator);
//        bridgeGame = new BridgeGame(gameRepository, bridgeMap, bridgeMaker);
//        bridgeGame.makeBridge(3);
//
//        // When
//        BridgeMap result = bridgeGame.move(0, MovingCommand.UP);
//
//        // Then
//        assertThat(result.getUpperMap()).containsExactly(RoundStatus.ROUND_CONTINUE.getValue());
//        assertThat(result.getLowerMap()).containsExactly(RoundStatus.SPACE.getValue());
//    }
//
//    @Test
//    @DisplayName("retry 메서드가 시도 횟수를 증가시키고 맵을 초기화하는지 테스트")
//    void retryShouldIncreaseAttemptsAndResetMap() {
//        // Given
//        BridgeNumberGenerator oneGenerator = () -> 1;
//        bridgeMaker = new BridgeMaker(oneGenerator);
//        bridgeGame = new BridgeGame(gameRepository, bridgeMap, bridgeMaker);
//        bridgeGame.makeBridge(3);
//        bridgeGame.move(0, MovingCommand.UP);
//
//        // When
//        bridgeGame.retry();
//
//        // Then
//        assertThat(gameRepository.getAttempts()).isEqualTo(2); // 기본값이 1이라고 가정
//        assertThat(bridgeMap.getUpperMap()).isEmpty();
//        assertThat(bridgeMap.getLowerMap()).isEmpty();
//    }
//
//    @Test
//    @DisplayName("getBridgeSize 메서드가 올바른 다리 크기를 반환하는지 테스트")
//    void getBridgeSizeShouldReturnCorrectSize() {
//        // Given
//        BridgeNumberGenerator oneGenerator = () -> 1;
//        bridgeMaker = new BridgeMaker(oneGenerator);
//        bridgeGame = new BridgeGame(gameRepository, bridgeMap, bridgeMaker);
//        bridgeGame.makeBridge(3);
//
//        // When
//        int size = bridgeGame.getBridgeSize();
//
//        // Then
//        assertThat(size).isEqualTo(3);
//    }
//
//    @Test
//    @DisplayName("isRoundEnd 메서드가 라운드 종료 여부를 올바르게 판단하는지 테스트")
//    void isRoundEndShouldCorrectlyIdentifyRoundEnd() {
//        // Given
//        BridgeNumberGenerator oneGenerator = () -> 1;
//        bridgeMaker = new BridgeMaker(oneGenerator);
//        bridgeGame = new BridgeGame(gameRepository, bridgeMap, bridgeMaker);
//        bridgeGame.makeBridge(3);
//
//        // When
//        boolean roundEnd = bridgeGame.isRoundEnd(0, MovingCommand.DOWN);
//
//        // Then
//        assertThat(roundEnd).isTrue(); // DOWN으로 이동하면 종료 조건에 부합
//    }
//
//    @Test
//    @DisplayName("getResult 메서드가 올바른 게임 결과를 반환하는지 테스트")
//    void getResultShouldReturnCorrectGameResult() {
//        // Given
//        BridgeNumberGenerator oneGenerator = () -> 1;
//        bridgeMaker = new BridgeMaker(oneGenerator);
//        bridgeGame = new BridgeGame(gameRepository, bridgeMap, bridgeMaker);
//        bridgeGame.makeBridge(3);
//        bridgeGame.move(0, MovingCommand.UP);
//        bridgeGame.setIsSuccessInGame();
//
//        // When
//        GameResult result = bridgeGame.getResult();
//
//        // Then
//        assertThat(result.getTryCount()).isEqualTo(1);
//        assertThat(result.isSuccess()).isTrue();
//        assertThat(result.getBridgeMap().getUpperMap()).containsExactly(RoundStatus.ROUND_CONTINUE.getValue());
//    }
//
//    @Test
//    @DisplayName("setIsSuccessInGame 메서드가 게임의 성공 상태를 설정하는지 테스트")
//    void setIsSuccessInGameShouldSetSuccessStatus() {
//        // Given
//        BridgeNumberGenerator oneGenerator = () -> 1;
//        bridgeMaker = new BridgeMaker(oneGenerator);
//        bridgeGame = new BridgeGame(gameRepository, bridgeMap, bridgeMaker);
//
//        // When
//        bridgeGame.setIsSuccessInGame();
//
//        // Then
//        assertThat(gameRepository.getIsSuccessInGame()).isTrue();
//    }
//}
