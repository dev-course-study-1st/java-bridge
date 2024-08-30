package bridge.util.converter;

public interface Converter<S, T>  {
    boolean supports(Object from, Class<T> to);

    T convert(S source);
}
