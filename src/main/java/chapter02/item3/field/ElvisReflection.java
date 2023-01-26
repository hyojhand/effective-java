package chapter02.item3.field;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// 생성자로 여러 인스턴스 만들기
public class ElvisReflection {
    public static void main(String[] args) {
        try {
            // getDeclaredConstructor()로 기본생성자에 접근
            Constructor<Elvis> defaultConstructor = Elvis.class.getDeclaredConstructor();
            // private이기 때문에 true로 하지않으면, IllegalAccessException 발생!
            defaultConstructor.setAccessible(true);
            Elvis.INSTANCE.sing();
            Elvis elvis1 = defaultConstructor.newInstance();
            Elvis elvis2 = defaultConstructor.newInstance();

            // 리플렉션을 사용하면 다른 객체가 새로 생성된다.
            // 인스턴스의 생성여부를 별도로 관리하여 인스턴스 생성을 막을 수 있다.
            System.out.println(elvis1 == elvis2); // false
            System.out.println(elvis1 == Elvis.INSTANCE); // false
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
