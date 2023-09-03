package chapter04.item19;

import java.time.Instant;

public final class Sub extends Super {

    private final Instant instant;

    Sub() {
//        Super();
        instant = Instant.now();
    }

    @Override
    public void overrideMe() {
        System.out.println(instant);
    }

    public static void main(String[] args) {
        // 상위 클래스의 생성자가 먼저 호출되면서, 인스턴스가 초기화 되기 전에 재정의한 메서드가 호출되어 null이 출력된다.
        Sub sub = new Sub();
        sub.overrideMe();
    }

}
