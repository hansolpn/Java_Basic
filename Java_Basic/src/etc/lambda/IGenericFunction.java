package etc.lambda;

@FunctionalInterface
public interface IGenericFunction<X, Y> {

    // X에서 Y를 추출
    Y apply (X x);
}
