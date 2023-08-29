package chapter04.item21;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFast {
    public static void main(String[] args) {
        List<Integer> fixNumbers = List.of(1, 2, 3, 4, 5);

        // Immutable Collection 예외
//        for (Integer number : fixNumbers) {
//            if (number == 3) {
//                fixNumbers.remove(number);
//            }
//        }

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // ConcurrentModificationException 발생 - Iterator로 컬렉션을 순회하는 중에 remove 하는 경우
//        for (Integer number : numbers) {
//            if (number == 3) {
//                numbers.remove(number);
//            }
//        }

        // Iterator를 직접 사용해서 remove
        for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext(); ) {
            Integer number = iterator.next();
            if (number == 3) {
                iterator.remove();
            }
        }

        // 인덱스 사용하기
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == 3) {
                numbers.remove(numbers.get(i));
            }
        }

        // removeIf
        numbers.removeIf(number -> number == 3);
    }
}
