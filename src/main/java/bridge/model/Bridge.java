package bridge.model;

import bridge.util.constant.MoveKey;

import java.util.List;
import java.util.Objects;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public void clear() {
        bridge.clear();
    }

    public void add(MoveKey moveKey) {
        bridge.add(moveKey.getMoveKey());
    }

    public int size() {
        return bridge.size();
    }

    public String get(int index) {
        return bridge.get(index);
    }

    @Override
    public String toString() {
        return "Bridge{" +
                "bridge=" + bridge +
                '}';
    }
}
