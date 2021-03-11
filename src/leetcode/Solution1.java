package leetcode;


class Solution1 {
    public int solution(int[] blocks) {

        if(blocks.length == 0){
            return 0;
        }
        int maxLeft = 0;
        int maxRight = 0;
        int maxRightValue = 0;
        int maxLeftValue = blocks[0];

        for (int i = 1; i < blocks.length; i++) {
            if(blocks[i] > blocks[i-1]){
                maxRight = i;
                maxRightValue = blocks[i];
            } else {
                break;
            }
        }

        int result = maxRight + 1;

        for (int i = 1; i < blocks.length; i++) {
            int left = 0;
            int right = 0;

            if(blocks[i] >  blocks[i-1] ){

            }

            for (int j = i - 1; j >= 0; j--) {
                if (blocks[j] >= blocks[j + 1]) {
                    left++;
                } else {
                    break;
                }
            }
            for (int k = i + 1; k < blocks.length; k++) {
                if (blocks[k] >= blocks[k - 1]) {
                    right++;
                } else {
                    break;
                }
            }
            int currentMax = left + right + 1;
            if(currentMax > result){
                result = currentMax;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] ranks = {4, 4, 3, 3, 1, 0};
        System.out.println(solution1.solution(ranks));
    }
}
