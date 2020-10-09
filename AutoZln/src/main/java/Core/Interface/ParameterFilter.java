package Core.Interface;

public interface ParameterFilter<T> {

    int getOrder();

    T dynamicParameterListener(T t);
}
