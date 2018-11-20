public class Palindrome {
	public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
	}
	public boolean isPalindrome(String word) {
//	    Deque d = wordToDeque(word);
//	    for (int i = 0; i < (int) (d.size() / 2); i++) {
//	        if (d.get(i) != d.get(d.size()- 1 - i)) {
//	            return false;
//            }
//        }
//        return true;
        return isPalindromeAux(wordToDeque(word));
    }
    private boolean isPalindromeAux(Deque<Character> d) {
	    if (d.size() <= 1) {
	        return true;
        } else {
	        if (d.removeFirst() != d.removeLast()) {
	            return false;
            } else {
	            return isPalindromeAux(d);
            }
        }
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque d = wordToDeque(word);
        return isPalindromeAux(d, cc);
    }
    private boolean isPalindromeAux(Deque<Character> d, CharacterComparator cc) {
	    if (d.size() <= 1) {
	        return true;
        } else {
	        if (cc.equalChars(d.removeFirst(), d.removeLast())) {
	            return isPalindromeAux(d, cc);
            } else {
	            return false;
            }
        }
    }

	
}
