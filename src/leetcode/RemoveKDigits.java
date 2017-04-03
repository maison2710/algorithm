package leetcode;

import java.util.Stack;

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
