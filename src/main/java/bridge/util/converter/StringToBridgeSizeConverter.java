package bridge.util.converter;

import bridge.domain.BridgeSize;

public class StringToBridgeSizeConverter implements Converter <String, BridgeSize> {

    @Override
    public boolean supports(Object from, Class<BridgeSize> to) {
        return from.getClass() == String.class && to == BridgeSize.class;
    }

    @Override
    public BridgeSize convert(String source) {
        checkEmpty(source);
        int input = toInt(source);
        return new BridgeSize(input);
    }

    private void checkEmpty(String source) {
        if (source.isEmpty()) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
    }

    private int toInt(String source) {
        try {
            return Integer.parseInt(source);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}
