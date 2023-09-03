package chapter04.item19;

public class Super {
    // 생성자가 재정의 가능 메서드를 호출하는 문제점
    public Super() {
        overrideMe();
    }

    public void overrideMe() {

    }
}
