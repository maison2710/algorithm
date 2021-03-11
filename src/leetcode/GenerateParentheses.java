package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        generateParenthesis(result, "", n, n);
        return result;
    }

    public void generateParenthesis(List<String> result, String output, int numOpen, int numClose) {
        if (numOpen == 0 && numClose == 0) {
            result.add(output);
        } else {
            if (numOpen == numClose) {
                generateParenthesis(result, output + "(", numOpen - 1, numClose);
            } else {
                if(numOpen > 0){
                    generateParenthesis(result, output + "(", numOpen - 1, numClose);
                }
                if(numClose > 0){
                    generateParenthesis(result, output + ")", numOpen, numClose - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        GenerateParentheses obj = new GenerateParentheses();
        System.out.println(obj.generateParenthesis(3));
    }
}
