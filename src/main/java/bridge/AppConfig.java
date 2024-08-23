package bridge;

import bridge.controller.BridgeController;
import bridge.domain.BridgeMap;
import bridge.repository.GameRepository;
import bridge.service.BridgeGame;
import bridge.util.converter.ConverterHolder;
import bridge.util.converter.StringToBridgeSizeConverter;
import bridge.util.converter.StringToMovingCommandConverter;
import java.util.List;

public class AppConfig {

    public BridgeController setSystem() {
        setConverters();
        return new BridgeController(bridgeGame());
    }

    private BridgeGame bridgeGame() {
        return new BridgeGame(gameRepository(), bridgeMap(), bridgeMaker());
    }

    private BridgeMaker bridgeMaker() {
        return new BridgeMaker(bridgeNumberGenerator());
    }

    private BridgeNumberGenerator bridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }

    private GameRepository gameRepository() {
        return new GameRepository();
    }

    private BridgeMap bridgeMap() {
        return new BridgeMap();
    }

    private void setConverters() {
        ConverterHolder.setConverters(List.of(
                new StringToBridgeSizeConverter(),
                new StringToMovingCommandConverter()
        ));
    }

    public void close() {
        ConverterHolder.clearHolder();
    }
}
