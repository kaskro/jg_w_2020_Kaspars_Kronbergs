package lv.javaguru.homework.lesson9.level1;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//Ok
public class UniqueWordVocabulary {

    private Set<String> wordVocabulary = new HashSet<>();

    public void addWord(String word) {
        if (word != null) {
            wordVocabulary.add(word);
        }
    }

    public int getUniqueWords() {
        return wordVocabulary.size();
    }

    public void printToConsole() {
        for (String word : wordVocabulary) {
            System.out.println(word);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UniqueWordVocabulary)) return false;
        UniqueWordVocabulary that = (UniqueWordVocabulary) o;
        return Objects.equals(wordVocabulary, that.wordVocabulary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordVocabulary);
    }

    @Override
    public String toString() {
        return "UniqueWordVocabulary{" +
                "wordVocabulary=" + wordVocabulary +
                '}';
    }
}
