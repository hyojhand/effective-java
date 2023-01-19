package chapter02.item01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// 서비스 제공 API
@Configuration
public class AppConfig {

    @Bean
    public HelloService helloService() {
        return new KoreaHelloService();
    }
}
