package leetcode;

/**
 * Plus One
 * Easy
 * <p>
 * 1412
 * <p>
 * 2258
 * <p>
 * Add to List
 * <p>
 * Share
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 * <p>
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int plus = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int localSum = digits[i] + plus;
            if (localSum == 10) {
                digits[i] = 0;
                plus = 1;
            } else {
                digits[i] = localSum;
                plus = 0;
            }
        }

        if (plus == 0) {
            return digits;
        } else {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = 0;
            }
            return result;
        }
    }
}
