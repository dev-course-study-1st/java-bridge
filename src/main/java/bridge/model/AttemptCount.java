package bridge.model;

public class AttemptCount {
    private int count;

    public AttemptCount(int count) {
        this.count = count;
    }

    public void increment(){
        count++;
    }

    public int getCount() {
        return count;
    }
}
