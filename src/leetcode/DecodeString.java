package leetcode;

import java.util.Stack;

public class DecodeString {
	public String decodeString(String s) {
		String res = "";
		char[] characters = s.toCharArray();
		Stack<String> resStack = new Stack<String>();
		Stack<Integer> countStack = new Stack<Integer>();
		String countTmp = "";

		for (int i = 0; i < characters.length; i++) {
			if (characters[i] == '[') {
				resStack.push(res);
				res = "";
			} else if (characters[i] == ']') {
				int count = countStack.pop();
				String tmp = "";
				for (int j = 0; j < count; j++) {
					tmp += res;
				}
				res = resStack.pop() + tmp;
			} else if (Character.isDigit(characters[i])) {
				countTmp += characters[i];
				if (!Character.isDigit(characters[i+1])) {
					countStack.push(Integer.parseInt(countTmp));
					countTmp = "";
				}
			} else {
				res += characters[i];
			}
		}

		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeString obj = new DecodeString();
		System.out.println(obj.decodeString("1[leetcode]"));
	}

}
