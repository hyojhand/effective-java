package chapter02.item5.springioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = AppConfiguration.class)
public class AppConfiguration {

    // @Component 어노테이션으로 등록한 Bean을 ComponentScan으로 찾기
//    @Bean
//    public SpellChecker spellChecker(Dictionary dictionary) {
//        return new SpellChecker(dictionary);
//    }
//
//    @Bean
//    public Dictionary dictionary() {
//        return new SpringDictionary();
//    }
}
