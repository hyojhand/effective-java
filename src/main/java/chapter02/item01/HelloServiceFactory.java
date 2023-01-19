package chapter02.item01;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.ServiceLoader;

public class HelloServiceFactory {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        HelloService ko = HelloService.of("ko");
        System.out.println(ko.hello());

        // 정적 팩터리 메서드를 작성하는 시점에 반환할 객체의 클래스가 존재하지 않아도 된다.
        // 서비스 접근 API
        ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);
        Optional<HelloService> helloServiceOptional = loader.findFirst();
        helloServiceOptional.ifPresent(h -> {
            System.out.println(h.hello());
        });

        // 리플렉션
        // 문자열로 클래스 읽어올 수 있다
        Class<?> aClass = Class.forName("chapter02.item01.KoreaHelloService");
        // getConstructor로 생성자를 가져와서 newInstance()로 인스턴스를 생성할 수 있다.
        Constructor<?> constructor = aClass.getConstructor();
        HelloService helloService = (HelloService) constructor.newInstance();
        System.out.println(helloService.hello());


    }
}
