package chapter02.item6;

import java.util.regex.Pattern;

public class RegularExpression {

    private static final Pattern SPLIT_PATTERN = Pattern.compile(",");

    public static void main(String[] args) {
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            String name = "hyo,son";
            name.split(",");
//            name = name.replaceAll(SPLIT_PATTERN.pattern(),":");
//            SPLIT_PATTERN.split(name);
        }
        System.out.println(System.nanoTime() - start);
    }
}
