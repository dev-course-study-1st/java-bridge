package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> value;

    public Bridge(List<String> value) {
        this.value = value;
    }

    public List<String> getValue() {
        return value;
    }
}
