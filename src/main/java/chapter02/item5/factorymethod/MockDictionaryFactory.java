package chapter02.item5.factorymethod;

import chapter02.item5.MockDictionary;
import chapter02.item5.Dictionary;

public class MockDictionaryFactory implements DictionaryFactory{
    @Override
    public Dictionary getDictionary() {
        return new MockDictionary();
    }
}
