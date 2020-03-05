package lv.javaguru.homework.lesson7.level3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeTest {

    @Test
    void shouldBePalindrome() {
        String palindrome = "Sum summus mus";

        assertTrue(Palindrome.isPalindrome(palindrome));
    }

    @Test
    void shouldNotBePalindrome() {
        String notPalindrome = "Random";

        assertFalse(Palindrome.isPalindrome(notPalindrome));
    }
}