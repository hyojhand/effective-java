package chapter03.item14;

import java.math.BigDecimal;

public class CompareToConvention {

    public static void main(String[] args) {
        BigDecimal n1 = BigDecimal.valueOf(23134134);
        BigDecimal n2 = BigDecimal.valueOf(11231230);
        BigDecimal n3 = BigDecimal.valueOf(53534552);
        BigDecimal n4 = BigDecimal.valueOf(11231230);

        // 반사성
        System.out.println(n1.compareTo(n1)); // 0

        // 대칭성
        System.out.println(n1.compareTo(n2)); // 양수
        System.out.println(n2.compareTo(n1)); // 음수

        // 추이성
        System.out.println(n3.compareTo(n1) > 0);
        System.out.println(n1.compareTo(n2) > 0);
        System.out.println(n3.compareTo(n2) > 0);

        // 일관성
        System.out.println(n4.compareTo(n2));
        System.out.println(n2.compareTo(n1));
        System.out.println(n4.compareTo(n1));

        // compareTo가 0이라면 equals는 true여야 한다. (하지만, 아닐 수도 있다.)
        BigDecimal oneZero = new BigDecimal("1.0");
        BigDecimal oneZeroZero = new BigDecimal("1.00");
        System.out.println(oneZero.compareTo(oneZeroZero)); // 둘이 같기 때문에 Tree, TreeMap 에는 하나만 들어간다.
        System.out.println(oneZero.equals(oneZeroZero)); // equals 비교는 같다고 나오지 않는다. 순서가 없는 콜렉션
    }
}
