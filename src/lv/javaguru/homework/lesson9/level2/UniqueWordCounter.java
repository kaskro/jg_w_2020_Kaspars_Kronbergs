package lv.javaguru.homework.lesson9.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UniqueWordCounter {

    private Map<String, Integer> wordCounter = new HashMap<>();

    public void addWord(String word) {
        if (word != null) {
            wordCounter.put(word, updateValue(word));
        }
    }

    public String mostCommonWord() {
        Map.Entry<String, Integer> mostCommon = null;
        for (Map.Entry<String, Integer> element : wordCounter.entrySet()) {
            if (mostCommon == null || mostCommon.getValue() < element.getValue()) {
                mostCommon = element;
            }
        }
        return mostCommon != null ? mostCommon.getKey() : "";
    }

    public void printToConsole() {
        for (var element : wordCounter.entrySet()) {
            System.out.println("Key: " + element.getKey() + ", value: " + element.getValue());
        }
    }

    public int getSize() {
        return wordCounter.size();
    }

    public int getValueByWord(String word) {
        return wordCounter.getOrDefault(word, 0);
    }

    private int updateValue(String word) {
        return wordCounter.containsKey(word) ? wordCounter.get(word) + 1 : 1;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UniqueWordCounter)) return false;
        UniqueWordCounter that = (UniqueWordCounter) o;
        return Objects.equals(wordCounter, that.wordCounter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordCounter);
    }

    @Override
    public String toString() {
        return "UniqueWordCounter{" +
                "wordCounter=" + wordCounter +
                '}';
    }
}
