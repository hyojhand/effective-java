package chapter02.item5.staticutils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpellCheckerTest {

    @Test
    void isValid() {
        assertThat(SpellChecker.isValid("test"));
    }

}