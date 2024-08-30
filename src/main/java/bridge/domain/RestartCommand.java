package bridge.domain;

import java.util.Arrays;

public enum RestartCommand {

    RESTART("R"),
    QUIT("Q");

    private final String value;

    RestartCommand(String value) {
        this.value = value;
    }

    public static RestartCommand findByInput(String input) {
        return Arrays.stream(RestartCommand.values())
                .filter(it -> it.value.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("R 이나 Q를 입력해주세요."));
    }

    public boolean isQuitGame() {
        return this == QUIT;
    }
}
