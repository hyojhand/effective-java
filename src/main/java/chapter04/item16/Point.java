package chapter04.item16;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        // 부가작업
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        // 부가작업
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
