package chapter02.item01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 서비스 접근 API
        HelloService helloService = applicationContext.getBean(HelloService.class);
        System.out.println(helloService.hello());
    }
}
