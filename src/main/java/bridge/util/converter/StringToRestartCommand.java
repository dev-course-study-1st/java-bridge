package bridge.util.converter;

import bridge.domain.RestartCommand;

public class StringToRestartCommand implements Converter <String, RestartCommand> {

    @Override
    public boolean supports(Object from, Class<RestartCommand> to) {
        return from.getClass() == String.class && to == RestartCommand.class;
    }

    @Override
    public RestartCommand convert(String source) {
        return RestartCommand.findByInput(source);
    }
}
