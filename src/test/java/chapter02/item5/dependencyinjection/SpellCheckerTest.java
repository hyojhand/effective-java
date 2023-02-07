package chapter02.item5.dependencyinjection;

import org.junit.jupiter.api.Test;

class SpellCheckerTest {

    @Test
    void isValid() {
        // 생성자에 자원을 바로 받는 방식
//        SpellChecker spellChecker = new SpellChecker(new DefaultDictionary());
//        spellChecker.isValid("test");

        // supplier에 준하는 메서드 참조 사용
        SpellChecker spellChecker = new SpellChecker(DictionaryFactory::get);
        spellChecker.isValid("test");

    }

}