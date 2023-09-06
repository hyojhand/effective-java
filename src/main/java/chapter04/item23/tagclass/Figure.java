package chapter04.item23.tagclass;

// 23-1 태그 달린 클래스
public class Figure {
    enum Shape {RECTANGLE, CIRCLE}

    // 태그 필드 - 현재 모양
    final Shape shape;

    // RECTANGLE 전용 필드
    double length;
    double width;

    // CIRCLE 전용 필드
    double radius;

    // 원용 생성자
    Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // 사각형용 생성자
    Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }
    }
}
