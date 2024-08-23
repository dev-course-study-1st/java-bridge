package bridge.utils.enums;

public enum RestartCommend {
    RESTART("R"),
    QUIT("Q");

    private final String commend;

    RestartCommend(String commend) {
        this.commend = commend;
    }

    public String getCommend() {
        return commend;
    }
}
