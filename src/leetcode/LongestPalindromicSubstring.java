package leetcode;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s == null || s.isEmpty()){
            return "";
        }

        int max = 1;
        String result = s.charAt(0) + "";

        for(int i = 1; i < s.length(); i++){
            if(isPalindrome(s.substring(i-max, i+1))){
                result = s.substring(i-max, i+1);
                max++;
            }

            if(i-max-1 >= 0 && isPalindrome(s.substring(i-max-1, i+1))){
                result = s.substring(i-max-1, i+1);
                max = max + 2;
            }
        }

        return result;
    }

    public boolean isPalindrome(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while(i< j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring object = new LongestPalindromicSubstring();
        System.out.println(object.longestPalindrome("cbbd"));
    }
}
