package bridge.utils.enums;

public enum MoveCommend {
    UP("U", 1),
    DOWN("D", 0);

    private final String commend;
    private final int number;

    MoveCommend(String commend, int number) {
        this.commend = commend;
        this.number = number;
    }

    public String getCommend() {
        return commend;
    }

    public static String numberOf(int number) {
        for(MoveCommend moveCommend:values()){
            if (moveCommend.number == number) {
                return moveCommend.commend;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_GENERATE.getMessage());
    }

    public static MoveCommend fromString(String commend) {
        for (MoveCommend moveCommend : MoveCommend.values()) {
            if (moveCommend.getCommend().equalsIgnoreCase(commend)) {
                return moveCommend;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_DIRECTION.getMessage());
    }

    public boolean isEqualTo(String commend){
        return this.commend.equals(commend);
    }
}
