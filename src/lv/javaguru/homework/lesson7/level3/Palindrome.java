package lv.javaguru.homework.lesson7.level3;

import java.util.Locale;

public class Palindrome {

    public static boolean isPalindrome(String input) {
        String[] characters = input.toLowerCase(Locale.ENGLISH).split("");
        for (int i = 0; i < characters.length; i++) {
            if (!isSameCharacter(characters, i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSameCharacter(String[] characters, int i) {
        return characters[i].equals(characters[characters.length - 1 - i]);
    }
}
