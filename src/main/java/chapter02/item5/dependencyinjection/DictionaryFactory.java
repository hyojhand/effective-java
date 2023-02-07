package chapter02.item5.dependencyinjection;

import chapter02.item5.DefaultDictionary;
import chapter02.item5.Dictionary;

public class DictionaryFactory {
    public static Dictionary get() {
        return new DefaultDictionary();
    }
}
