package bridge.domain;

import java.util.Arrays;

public enum MovingCommand {

    UP("U", 1),
    DOWN("D", 0);

    private final String value;
    private final int number;

    MovingCommand(String value, int number) {
        this.value = value;
        this.number = number;
    }

    public static MovingCommand findByInput(String input) {
        return Arrays.stream(MovingCommand.values())
                .filter(it -> it.value.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("U 나 D를 입력해주세요."));
    }

    public static String findByNumber(int number) {
        return Arrays.stream(MovingCommand.values())
                .filter(it -> it.number == number)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("올바르지 않은 변수를 받았습니다."))
                .value;
    }

    public String getValue() {
        return value;
    }
}
