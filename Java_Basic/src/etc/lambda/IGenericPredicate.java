package etc.lambda;

@FunctionalInterface
public interface IGenericPredicate<T> {
    boolean test(T t);
}
