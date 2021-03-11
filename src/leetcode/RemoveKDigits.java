package leetcode;

import java.util.Stack;

/**
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 *
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 *
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
		if (k >= num.length()) {
			return "0";
		}
		String res = "";

		Stack<Character> resStack = new Stack<Character>();
		for (int i = 0; i < num.length(); i++) {
			while (k > 0 && !resStack.isEmpty()
					&& resStack.peek() > num.charAt(i)) {
				resStack.pop();
				k--;
			}
			if (k == 0 || resStack.isEmpty()
					|| resStack.peek() <= num.charAt(i)) {
				if (resStack.isEmpty() && num.charAt(i) == '0') {
					continue;
				}
				resStack.push(num.charAt(i));
			}
		}
		while (k > 0 && !resStack.isEmpty()) {
			resStack.pop();
			k--;
		}

		// construct the number from the stack
		StringBuilder sb = new StringBuilder();
		while (!resStack.isEmpty())
			sb.append(resStack.pop());
		res = sb.reverse().toString();

		if (res.isEmpty()) {
			return "0";
		}

		return res;

	}

	public static void main(String[] args) {
		RemoveKDigits obj = new RemoveKDigits();
		System.out.println(obj.removeKdigits("1", 1));
	}

}
