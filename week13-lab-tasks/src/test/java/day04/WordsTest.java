package day04;

import org.junit.jupiter.api.Test;

class WordsTest {

    @Test
    void selectAllWords() {
        Words words = new Words();
        words.selectAllVowels("Ez egy szep mondat");
        System.out.println(words.getVowelCounter());
    }
}