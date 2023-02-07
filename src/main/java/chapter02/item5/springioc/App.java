package chapter02.item5.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        SpellChecker spellChecker = applicationContext.getBean(SpellChecker.class);
        spellChecker.isValid("test");
    }
}
