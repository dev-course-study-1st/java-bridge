package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> value;

    public Bridge(List<String> value) {
        this.value = value;
    }

    public boolean canGo(int index, String moving) {
        return value.get(index).equals(moving);
    }

    public List<String> getValue() {
        return value;
    }
}
