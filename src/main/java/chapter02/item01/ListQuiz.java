package chapter02.item01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListQuiz {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(22);
        numbers.add(33);
        numbers.add(5);

        Comparator<Integer> desc = (o1, o2) -> o2 - o1;
//        Comparator<Integer> desc = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        };

        numbers.sort(desc);
        numbers.sort(desc.reversed());
        System.out.println(numbers);


    }
}
