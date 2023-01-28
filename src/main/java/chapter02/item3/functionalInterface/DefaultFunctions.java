package chapter02.item3.functionalInterface;

import chapter02.item3.methodreference.Person;

import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DefaultFunctions {

    public static void main(String[] args) {
//        Function<Integer, String> intToString = (i) -> "hello";
        Function<Integer, String> intToString = Object::toString;

        // 매개변수가 없는 생성자 참조로 사용
        Supplier<Person> personSupplier = Person::new;
        // LocalDate를 매개변수로 받는 생성자 참조로 사용
        Function<LocalDate, Person> personFunction = Person::new;

        Consumer<Integer> integerConsumer = System.out::println;

        Predicate<Person> predicate;
    }
}