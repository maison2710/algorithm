package leetcode;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * <p>
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                if (isPalindrome(s.substring(i, j)) || isPalindrome(s.substring(i + 1, j + 1))) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 0 | s.length() == 1) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeII test = new ValidPalindromeII();
        System.out.println(test.validPalindrome("aba"));
    }
}
