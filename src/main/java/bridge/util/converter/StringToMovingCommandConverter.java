package bridge.util.converter;

import bridge.domain.MovingCommand;

public class StringToMovingCommandConverter implements Converter <String, MovingCommand> {

    @Override
    public boolean supports(Object from, Class<MovingCommand> to) {
        return from.getClass() == String.class && to == MovingCommand.class;
    }

    @Override
    public MovingCommand convert(String source) {
        return MovingCommand.findByInput(source);
    }
}
