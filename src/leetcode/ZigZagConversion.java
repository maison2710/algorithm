package leetcode;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(s.isEmpty()){
            return "";
        }
        if(numRows == 1){
            return s;
        }
        String result = "";
        int partSize = 2*numRows-2;

        for(int i = 0; i < numRows; i++){
            int j = i;

            if(i == 0 || i == numRows -1){
                while(j < s.length()){
                    result += s.charAt(j);
                    j += partSize;
                }
            } else {
                while(j < s.length()){
                    result += s.charAt(j);
                    int next = j + partSize - 2*i;
                    if(next < s.length()){
                        result += s.charAt(next);
                    }
                    j += partSize;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ZigZagConversion obj = new ZigZagConversion();
        System.out.println(obj.convert("PAYPALISHIRING", 4));
    }
}
