package chapter04.item21;

public class SubClass extends SuperClass implements MarkerInterface{
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.hello();
        // 호출 순서는 클래스가 인터페이스를 이긴다. 즉, superClass의 메서드는 private임에도 접근하려하여 에러가 난다.
    }
}
