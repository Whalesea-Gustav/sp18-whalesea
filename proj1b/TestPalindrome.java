import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator cc = new OffByOne();
    static CharacterComparator cc2 = new OffByN(5);

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.

    @Test
    public void testIsPalindrome() {
        assertFalse(palindrome.isPalindrome("persiflage"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));
    }
    @Test
    public void testIsPalindromeOffByOne() {
        assertFalse(palindrome.isPalindrome("persiflage", cc));
        assertTrue(palindrome.isPalindrome("racebbq", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("", cc));
        assertTrue(palindrome.isPalindrome("AB", cc));
        assertTrue(palindrome.isPalindrome("ARACEBBQB", cc));


    }

    @Test
    public void testIsPalindromeOffByN() {
        assertFalse(palindrome.isPalindrome("persiflage", cc2));
        assertTrue(palindrome.isPalindrome("abchgf", cc2));
        assertTrue(palindrome.isPalindrome("a", cc2));
        assertTrue(palindrome.isPalindrome("", cc2));
    }


}
