package chapter02.item5.springioc;

import chapter02.item5.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpringDictionary implements Dictionary {
    @Override
    public boolean contains(String word) {
        System.out.println("spring ioc " + word);
        return false;
    }

    @Override
    public List<String> closeWordsTo(String word) {
        return null;
    }
}
