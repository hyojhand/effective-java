package chapter02.item5.factorymethod;

import chapter02.item5.DefaultDictionary;
import chapter02.item5.Dictionary;

public class DefaultDictionaryFactory implements DictionaryFactory{
    @Override
    public Dictionary getDictionary() {
        return new DefaultDictionary();
    }
}
