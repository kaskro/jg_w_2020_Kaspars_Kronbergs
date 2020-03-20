package lv.javaguru.homework.lesson9.level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniqueWordVocabularyTest {

    @Test
    void shouldAddWord() {
        UniqueWordVocabulary vocabulary = new UniqueWordVocabulary();
        vocabulary.addWord("Demo");
        assertEquals(1, vocabulary.getUniqueWords());
    }

    @Test
    void shouldNotAddWordWhenNullIsProvided() {
        UniqueWordVocabulary vocabulary = new UniqueWordVocabulary();
        vocabulary.addWord(null);
        assertEquals(0, vocabulary.getUniqueWords());
    }

    @Test
    void shouldGetUniqueWords() {
        UniqueWordVocabulary vocabulary = new UniqueWordVocabulary();
        vocabulary.addWord("Demo");
        vocabulary.addWord("Demo");
        vocabulary.addWord("Lego");
        vocabulary.addWord("Lego");
        vocabulary.addWord("Demo");
        assertEquals(2, vocabulary.getUniqueWords());
    }
}