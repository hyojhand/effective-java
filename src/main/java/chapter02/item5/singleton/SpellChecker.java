package chapter02.item5.singleton;

import chapter02.item5.DefaultDictionary;
import chapter02.item5.Dictionary;

import java.util.List;

public class SpellChecker {

    private final Dictionary dictionary = new DefaultDictionary();

    private SpellChecker() {
    }

    public static final SpellChecker INSTANCE = new SpellChecker();

    public boolean isValid(String word) {
        // TODO 여기 SpellChecker 코드
        return dictionary.contains(word);
    }

    public List<String> suggestions(String typo) {
        // TODO 여기 SpellChecker 코드
        return dictionary.closeWordsTo(typo);
    }
}
