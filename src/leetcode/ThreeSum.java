package leetcode;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        Arrays.sort(nums);

        if (nums.length < 3 || nums[0] + nums[1] + nums[2] > 0 || nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < 0) {
            return new ArrayList<>();
        }

        for (int i = 0; i < nums.length - 2; i++) {
            int m = i + 1;
            int n = nums.length - 1;
            while (m < n) {
                int total = nums[i] + nums[m] + nums[n];
                if (total == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[m]);
                    tmp.add(nums[n]);
                    result.add(tmp);
                    m++;
                    n--;
                } else if (total < 0) {
                    m++;
                } else {
                    n--;
                }
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();
        int[] array ={-1, 0, 1, 2, -1, -4};
        System.out.println(obj.threeSum(array));
    }
}
