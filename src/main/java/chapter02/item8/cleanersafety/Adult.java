package chapter02.item8.cleanersafety;

// AutoCloseable의 close() 메서드로 자원 정리
public class Adult {
    public static void main(String[] args) {
        try (Room myRoom = new Room(7)) {
            System.out.println("안녕~");
        }
    }
}
