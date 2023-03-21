package chapter04.item18.composition;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        InstrumentedHashSet<String> extendSet = new InstrumentedHashSet<>();
        extendSet.addAll(List.of("가","나","다"));
        System.out.println(extendSet.getAddCount()); // 6

        Set<String> set = new HashSet<>();
        InstrumentedSet<String> compositionSet = new InstrumentedSet<>(set);
        compositionSet.addAll(List.of("가","나","다"));
        System.out.println(compositionSet.getAddCount()); // 3
    }
}
