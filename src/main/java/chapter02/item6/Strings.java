package chapter02.item6;

public class Strings {
    public static void main(String[] args) {
        String hello = "hello";
        String hello2 = new String("hello"); // 잘못된 방법
        String hello3 = "hello";

        System.out.println(hello == hello2);
        System.out.println(hello.equals(hello2));
        System.out.println(hello == hello3);
    }
}
