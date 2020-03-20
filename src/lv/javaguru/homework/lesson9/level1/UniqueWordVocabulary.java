package lv.javaguru.homework.lesson9.level1;

import java.util.HashSet;
import java.util.Set;

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

}
