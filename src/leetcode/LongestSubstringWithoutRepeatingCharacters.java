package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int result = 0;
        Map<String, Integer> window = new HashMap<String, Integer>();
        for (int i = 0; i < s.length(); i++) {
            String element = s.charAt(i) + "";
            if(window.containsKey(element) && window.get(element) >= start){
                start = window.get(element) + 1;
            }
            window.put(element, i);

            System.out.println("start = " + start + " | result = " + (i - start + 1));

            if(result < i - start + 1){
                result = i - start + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(obj.lengthOfLongestSubstring("abba"));
    }
}
