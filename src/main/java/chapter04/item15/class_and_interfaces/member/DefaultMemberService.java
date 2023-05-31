package chapter04.item15.class_and_interfaces.member;

import java.util.Arrays;

// 구현체이기 때문에, 내부 패키지에서만 알면 되기 때문에 public은 굳이 필요 없지 않을까?
class DefaultMemberService implements MemberService{
    // 해당 클래스에서만 어떤 클래스를 사용한다면

    private String name;

    /**
     * inner 클래스이지만 static이기에 해당 클래스와 관련이 없는 독립적인 관계이다.
     * 감싸는 쪽에서만 사용하는 일방적인 관계로 만들 수 있다.
     */
    private static class PrivateStaticClass {

    }

    /**
     * privateClass 입장에서는 자신을 사용하는 외부 클래스의
     * 필드를 마음껏 사용할 수 있으므로 참조하는 관계가 된다.
     */
    private class PrivateClass {
        void doPrint() {
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        Arrays.stream(PrivateClass.class.getDeclaredFields()).forEach(System.out::println);
    }

}
