package etc.lambda;

public class LightApplePredicate implements IApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() <= 100;
    }
}
