package bridge.domain;

import java.util.Arrays;

public enum MovingCommand {

    UP("U"),
    DOWN("D");

    private final String value;

    MovingCommand(String value) {
        this.value = value;
    }

    public static MovingCommand findByInput(String input) {
        return Arrays.stream(MovingCommand.values())
                .filter(it -> it.value.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("U 나 D를 입력해주세요."));
    }

    public String getValue() {
        return value;
    }
}
