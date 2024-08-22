package bridge;

import bridge.controller.BridgeController;
import bridge.repository.GameRepository;
import bridge.service.BridgeGame;
import bridge.service.BridgeService;
import bridge.util.converter.ConverterHolder;
import bridge.util.converter.StringToBridgeSizeConverter;
import bridge.util.converter.StringToMovingCommandConverter;
import java.util.List;

public class AppConfig {

    public BridgeController setSystem() {
        setConverters();
        return new BridgeController(bridgeService());
    }

    private BridgeService bridgeService() {
        return new BridgeService(bridgeMaker(), bridgeGame(), new GameRepository());
    }

    private BridgeMaker bridgeMaker() {
        return new BridgeMaker(bridgeNumberGenerator());
    }

    private BridgeNumberGenerator bridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }

    private BridgeGame bridgeGame() {
        return new BridgeGame();
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
