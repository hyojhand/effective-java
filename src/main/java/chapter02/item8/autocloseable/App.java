package chapter02.item8.autocloseable;

public class App {
    public static void main(String[] args) {
        try(AutoCloseableExample good = new AutoCloseableExample("")) {
            // TODO 자원 반납 처리
        }
    }
}
