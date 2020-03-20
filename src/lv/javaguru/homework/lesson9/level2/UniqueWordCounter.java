package lv.javaguru.homework.lesson9.level2;

import java.util.HashMap;
import java.util.Map;

public class UniqueWordCounter {

    private Map<String, Integer> wordCounter = new HashMap<>();

    public void addWord(String word) {
        if (word != null) {
            wordCounter.put(word, updateValue(word));
        }
    }

    public String mostCommonWord() {
        String commonWord = "";
        int topCount = 0;
        for (var element : wordCounter.entrySet()) {
            if (element.getValue() > topCount) {
                topCount = element.getValue();
                commonWord = element.getKey();
            }
        }
        return commonWord;
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

}
