package chapter02.item3.field;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcertTest {

    // Elvis 객체를 직접 사용해서 테스트
//    @Test
//    void perform() {
//        Concert concert = new Concert(Elvis.INSTANCE);
//        concert.perform();
//
//        assertTrue(concert.isLightsOn());
//        assertTrue(concert.isMainStateOpen());
//    }

    @Test
    void perform2() {
        // 가짜 대역으로 테스트할 수 있기 때문에 비용을 줄일 수 있다!
        Concert concert = new Concert(new MockElvis());
        concert.perform();

        assertTrue(concert.isLightsOn());
        assertTrue(concert.isMainStateOpen());
    }

}