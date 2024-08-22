package bridge.domain;

public enum RoundStatus {
    ROUND_CONTINUE("O"),
    ROUND_END("X"),
    SPACE(" ");

    private final String value;

    RoundStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
