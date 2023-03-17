package chapter03.item11;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<PhoneNumber, String> map = new HashMap<>();

        PhoneNumber number1 = new PhoneNumber(123, 456, 7890);
        PhoneNumber number2 = new PhoneNumber(123, 456, 7890);

//         TODO 같은 인스턴스인데 다른 hashCode
//         다른 인스턴스인데 같은 hashCode를 쓴다면?
        PhoneNumber number3 = new PhoneNumber(456, 789, 1111);
        System.out.println(number1.equals(number2));
        System.out.println(number1.hashCode());
        System.out.println(number2.hashCode());

        map.put(number1, "son");
        map.put(number2, "hyo");

        String name = map.get(number1); // son
        String name2 = map.get(new PhoneNumber(123,456,7890)); // null
        System.out.println(name);
    }
}
