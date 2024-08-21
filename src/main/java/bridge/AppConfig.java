package bridge;

import bridge.controller.BridgeController;
import bridge.util.converter.ConverterHolder;
import bridge.util.converter.StringToBridgeSizeConverter;
import java.util.List;

public class AppConfig {

    public BridgeController setSystem() {
        setConverters();
        return new BridgeController();
    }

    private void setConverters() {
        ConverterHolder.setConverters(List.of(
                new StringToBridgeSizeConverter()
        ));
    }

    public void close() {
        ConverterHolder.clearHolder();
    }
}
