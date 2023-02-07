package chapter02.item5.dependencyinjection;

import chapter02.item5.Dictionary;

import java.util.List;
import java.util.function.Supplier;

public class SpellChecker {

    private final Dictionary dictionary;

    // 생성자에 자원 팩터리를 넘겨주는 방식
//    public SpellChecker(DictionaryFactory dictionaryFactory) {
//        this.dictionary = dictionaryFactory.get();
//    }

    // Supplier 인터페이스 사용
    public SpellChecker(Supplier<? extends Dictionary> dictionarySupplier) {
        this.dictionary = dictionarySupplier.get();
    }

    public boolean isValid(String word) {
        // TODO 여기 SpellChecker 코드
        return dictionary.contains(word);
    }

    public List<String> suggestions(String typo) {
        // TODO 여기 SpellChecker 코드
        return dictionary.closeWordsTo(typo);
    }
}
