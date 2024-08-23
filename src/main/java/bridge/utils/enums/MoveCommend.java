package bridge.utils.enums;

public enum MoveCommend {
    DOWN("D", 0),
    UP("U", 1);

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

    public boolean isEqualTo(String commend){
        return this.commend.equals(commend);
    }
}
