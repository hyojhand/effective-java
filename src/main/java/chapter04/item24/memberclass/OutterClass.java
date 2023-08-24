package chapter04.item24.memberclass;

/**
 * 바깥 클래스의 인스턴스에 대한 참조가 있다. (바깥 클래스 없이는 멤버 클래스는 생성할 수 없다)
 * 특정 InnerClass가 OutterClass에 참조하는 경우가 많다면 비정적 멤버 클래스로 적합하다.
 */
public class OutterClass {

    private int number = 10;

    void printNumber() {
        InnerClass innerClass = new InnerClass();
    }

    private class InnerClass {
        void doSomething() {
            System.out.println(number);
            OutterClass.this.printNumber();
        }
    }

    public static void main(String[] args) {
        InnerClass innerClass = new OutterClass().new InnerClass();
        innerClass.doSomething();


    }

}
