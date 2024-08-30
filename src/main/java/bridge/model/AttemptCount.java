package bridge.model;

import static bridge.utils.enums.Const.ATTEMPT_INIT_NUMBER;

public class AttemptCount {
    private int count;

    public AttemptCount() {
        this.count = ATTEMPT_INIT_NUMBER.getNumber();
    }

    public void increment(){
        count++;
    }

    public int getCount() {
        return count;
    }
}
