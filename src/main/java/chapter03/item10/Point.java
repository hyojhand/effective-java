package chapter03.item10;

import java.util.ArrayList;
import java.util.List;

// 단순한 불변 2차원 정수 점(point) 클래스
public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        // 1. == 연산자로 입력이 자기 자신의 참조인지 확인한다. (반사성)
        if (this == o) {
            return true;
        }

        // 2. instanceof 연산자로 타입 확인한다.
        if (!(o instanceof Point)) {
            return false;
        }

        // 3. 입력을 올바른 타입으로 형변환한다.
        Point p = (Point) o;

        // 4. 핵심 필드들이 모두 일치하는지 하나씩 검사한다.
        return p.x == x && p.y == y;
    }

    public static void main(String[] args) {
        Point point = new Point(1, 2);
        List<Point> points = new ArrayList<>();
        points.add(point);
        System.out.println(points.contains(new Point(1, 2)));
    }

    // 잘못된 코드 - 리스코프 치환 원칙 위배! (59쪽)
//    @Override public boolean equals(Object o) {
//        if (o == null || o.getClass() != getClass())
//            return false;
//        Point p = (Point) o;
//        return p.x == x && p.y == y;
//    }

    // 아이템 11 참조
    @Override public int hashCode()  {
        return 31 * x + y;
    }
}

