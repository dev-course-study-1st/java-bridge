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

    public boolean isEqualTo(String commend){
        return this.commend.equals(commend);
    }

}
