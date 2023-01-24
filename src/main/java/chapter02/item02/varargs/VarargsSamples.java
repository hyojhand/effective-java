package chapter02.item02.varargs;

import java.util.Arrays;

public class VarargsSamples {
    public void printNumbers(int... numbers) {
        System.out.println(numbers.getClass().getCanonicalName()); // 어떤 타입인지 int[]
        System.out.println(numbers.getClass().getComponentType()); // 내부의 값이 어떤 타입인지 int
        Arrays.stream(numbers).forEach(System.out::println);
    }

    public static void main(String[] args) {
        VarargsSamples samples = new VarargsSamples();
        samples.printNumbers(5, 10, 15);
    }
}
