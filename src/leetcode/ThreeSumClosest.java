package leetcode;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2];
        int diff = Integer.MAX_VALUE;

        if(nums.length ==3){
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int m = i + 1;
            int n = nums.length - 1;
            while (m < n) {
                int sum = nums[i] + nums[m] + nums[n];
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    n--;
                } else {
                    m++;
                }

                if (Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    result = sum;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSumClosest obj = new ThreeSumClosest();
        int[] array = {1, 1, 1, 1};
        System.out.println(obj.threeSumClosest(array, 3));
    }
}
