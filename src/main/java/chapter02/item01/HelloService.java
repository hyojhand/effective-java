package chapter02.item01;
// 서비스 제공자 인터페이
public interface HelloService {

    String hello();

//    default String hello() {
//        System.out.println("hello2");
//        return "hello2";
//    }

    static HelloService of(String lang) {
        if (lang.equals("ko")) {
            return new KoreaHelloService();
        } else {
            return new EnglishHelloService();
        }
    }

    // 인터페이스에 정적 메서드 선언
    static String hi() {
        prepareMessage();
        return "hi";
    }

    default String bye() {
        prepareMessage();
        return "bye";
    }

    static private void prepareMessage() {
    }
}
