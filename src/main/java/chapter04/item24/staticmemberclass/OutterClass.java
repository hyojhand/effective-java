package chapter04.item24.staticmemberclass;

/**
 * static 멤버 클래스는 바깥 클래스의 static 변수에 접근할 수 있다.
 * 바깥 클래스의 인스턴스가 필요하지 않아 독립적이다.
 */
public class OutterClass {

    private static int number = 10;

    static private class InnerClass {
        void doSomething() {
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        innerClass.doSomething();
    }
}
