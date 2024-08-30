package bridge.util.converter;

import java.util.ArrayList;
import java.util.List;

public class ConverterHolder {
    private static final List<Converter> converterHolder = new ArrayList<>();

    public static void setConverters(List<Converter> converters) {
        converterHolder.addAll(converters);
    }

    public static <T> T convert(Object target, Class<T> convertTo) {
        for (Converter converter : converterHolder) {
            if (converter.supports(target, convertTo)) {
                return (T) converter.convert(target);
            }
        }
        throw new IllegalArgumentException("잘못된 입력 및 반환 형식입니다.");
    }

    public static void clearHolder() {
        converterHolder.clear();
    }
}
