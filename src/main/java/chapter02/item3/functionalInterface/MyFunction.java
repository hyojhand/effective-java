package chapter02.item3.functionalInterface;

@FunctionalInterface
public interface MyFunction {

    String valueOf(Integer integer);

    static String hello() {
        return "hello";
    }
}
