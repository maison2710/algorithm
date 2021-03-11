package leetcode;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 * <p>
 * Input: "race a car"
 * Output: false
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (!isLetterOrDigit(s.charAt(i))) {
                i++;
            } else if (!isLetterOrDigit(s.charAt(j))) {
                j--;
            } else {
                if (s.charAt(i) == s.charAt(j)) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isLetterOrDigit(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        ValidPalindrome test = new ValidPalindrome();
        System.out.println(test.isPalindrome("race a car"));
    }
}
