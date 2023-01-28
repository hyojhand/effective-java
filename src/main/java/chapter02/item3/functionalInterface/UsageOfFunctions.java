package chapter02.item3.functionalInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsageOfFunctions {

    public static void main(String[] args) {
        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.of(1982, 7, 15));
        dates.add(LocalDate.of(2011, 3, 2));
        dates.add(LocalDate.of(2013, 1, 28));

        List<Integer> before2000 = dates.stream()
                .filter(d -> d.isBefore(LocalDate.of(2000, 1, 1)))
                .map(LocalDate::getYear)
                .collect(Collectors.toList());
    }
}