package leetcode;

public class ATOI {
    /**
     * Implement atoi which converts a string to an integer.
     * <p>
     * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
     * <p>
     * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
     * <p>
     * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
     * <p>
     * If no valid conversion could be performed, a zero value is returned.
     * <p>
     * Note:
     * <p>
     * Only the space character ' ' is considered as whitespace character.
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
     * Example 1:
     * <p>
     * Input: "42"
     * Output: 42
     * Example 2:
     * <p>
     * Input: "   -42"
     * Output: -42
     * Explanation: The first non-whitespace character is '-', which is the minus sign.
     * Then take as many numerical digits as possible, which gets 42.
     * Example 3:
     * <p>
     * Input: "4193 with words"
     * Output: 4193
     * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
     * Example 4:
     * <p>
     * Input: "words and 987"
     * Output: 0
     * Explanation: The first non-whitespace character is 'w', which is not a numerical
     * digit or a +/- sign. Therefore no valid conversion could be performed.
     * Example 5:
     * <p>
     * Input: "-91283472332"
     * Output: -2147483648
     * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
     * Thefore INT_MIN (−231) is returned.
     */
    public int myAtoi(String str) {
        boolean flag = false;
        int multiply = 1;
        long result = 0;
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (current == ' ' && !flag) {
                continue;
            }

            if (current != ' ' && !flag) {
                flag = true;
                if (current == '-') {
                    multiply = -1;
                    continue;
                } else if(current == '+') {
                    continue;
                } else if (!Character.isDigit(current)) {
                    return 0;
                }
            }

            if (Character.isDigit(current)) {
                result = result * 10 + (current - '0');
            } else {
                break;
            }

            if (result * multiply > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (result * multiply < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

        }

        return (int) result * multiply;
    }

    public static void main(String[] args) {
        ATOI obj = new ATOI();
        System.out.println(obj.myAtoi("   +0 123"));
    }
}
