package chapter02.item8.cleanersafety;

// cleaner 안전망을 사용해서 자원 반납
public class Teenager {

    public static void main(String[] args) {
        new Room(99);
        System.out.println("아무렴");

        // GC를 강제로 호출하는 이런 방식에 의존해서는 절대 안 된다!
//        System.gc();
    }
}
