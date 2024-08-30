package bridge;

import bridge.controller.BridgeController;
import bridge.domain.BridgeMap;
import bridge.domain.GameStatus;
import bridge.service.BridgeGame;
import bridge.util.converter.ConverterHolder;
import bridge.util.converter.StringToBridgeSizeConverter;
import bridge.util.converter.StringToMovingCommandConverter;
import bridge.util.converter.StringToRestartCommand;
import java.util.List;

public class AppConfig {

    public BridgeController setSystem() {
        setConverters();
        return new BridgeController(bridgeGame());
    }

    private BridgeGame bridgeGame() {
        return new BridgeGame(bridgeMap(), bridgeMaker(), gameStatus());
    }

    private BridgeMaker bridgeMaker() {
        return new BridgeMaker(bridgeNumberGenerator());
    }

    private BridgeNumberGenerator bridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }

    private GameStatus gameStatus() {
        return new GameStatus();
    }

    private BridgeMap bridgeMap() {
        return new BridgeMap();
    }

    private void setConverters() {
        ConverterHolder.setConverters(List.of(
                new StringToBridgeSizeConverter(),
                new StringToMovingCommandConverter(),
                new StringToRestartCommand()
        ));
    }

    public void close() {
        ConverterHolder.clearHolder();
    }
}
