package chapter02.item01;

public interface HelloService2 {
    default String hello() {
        System.out.println("hello2");
        return "hello2";
    }
}
