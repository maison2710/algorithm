package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		Map<Character, Character> map = new HashMap<>();
		map.put('{', '}');
		map.put('(', ')');
		map.put('[', ']');

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char tmp = s.charAt(i);
			if (map.containsKey(tmp)) {
				stack.push(tmp);
			} else {
				if (stack.isEmpty() || map.get(stack.pop()) != tmp) {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		ValidParentheses obj = new ValidParentheses();
		System.out.println(obj.isValid("()[]}"));
	}
}
