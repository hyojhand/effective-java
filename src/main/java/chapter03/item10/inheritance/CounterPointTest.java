package chapter03.item10.inheritance;

import chapter03.item10.Color;
import chapter03.item10.Point;

import java.util.Set;

// CounterPoint를 Point로 사용하는 테스트 프로그램
public class CounterPointTest {
    // 단위 원 안의 모든 점을 포함하도록 unitCircle을 초기화한다.
    private static final Set<Point> unitCircle = Set.of(
            new Point( 1,  0), new Point( 0,  1),
            new Point(-1,  0), new Point( 0, -1));

    public static boolean onUnitCircle(Point p) {
        return unitCircle.contains(p);
    }

    public static void main(String[] args) {
        Point p1 = new Point(1,  0);
        Point p2 = new CounterPoint(1, 0);
        Point p3 = new ColorPoint(1, 0, Color.BLUE);
        Point p4 = new chapter03.item10.composition.ColorPoint(1, 0, Color.BLUE).asPoint();

        System.out.println(onUnitCircle(p1)); // true

        // true를 출력해야 하지만, Point의 equals가 getClass를 사용해 작성되었다면 그렇지 않다.
        // 객체지향적으로는 true가 나와야 한다. 상위 클래스 타입으로 동작하는 클래스 대신에 하위 클래스 타입의 인스턴스를 가져도 그대로 동작해야 한다.
        System.out.println(onUnitCircle(p2));
    }
}