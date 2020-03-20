package lv.javaguru.homework.lesson9.level2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniqueWordCounterTest {

    private UniqueWordCounter vocabulary;

    @BeforeEach
    void setUp() {
        vocabulary = new UniqueWordCounter();
    }

    @Test
    void shouldAddWord() {
        vocabulary.addWord("Test");
        assertEquals(1, vocabulary.getSize());
    }

    @Test
    void shouldAddWordAndIncreaseValue() {
        vocabulary.addWord("Test");
        vocabulary.addWord("Test");
        assertEquals(2, vocabulary.getValueByWord("Test"));
    }

    @Test
    void shouldNotAddWordWhenNullIsProvided() {
        vocabulary.addWord(null);
        assertEquals(0, vocabulary.getSize());
    }

    @Test
    void shouldReturnMostCommonWord() {
        vocabulary.addWord("apple");
        vocabulary.addWord("apple");
        vocabulary.addWord("mango");
        assertEquals("apple", vocabulary.mostCommonWord());
    }

    @Test
    void shouldReturnFirstMostCommonWordWhenTwoHaveSameValue() {
        vocabulary.addWord("apple");
        vocabulary.addWord("apple");
        vocabulary.addWord("mango");
        vocabulary.addWord("mango");
        assertEquals("apple", vocabulary.mostCommonWord());
    }

}