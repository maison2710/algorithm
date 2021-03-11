package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Sort Colors
 * Medium
 * <p>
 * 2925
 * <p>
 * 209
 * <p>
 * Add to List
 * <p>
 * Share
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note: You are not suppose to use the library's sort function for this problem.
 * <p>
 * Example:
 * <p>
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 * <p>
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (right >= 0 && nums[right] == 2) {
            right--;
        }

        while (left < nums.length && nums[left] == 0) {
            left++;
        }

        for (int i = left; i <= right; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[left];
                nums[left] = 0;
                while (nums[left] == 0) {
                    left++;
                }
                i = left - 1;
            } else if (nums[i] == 2) {
                nums[i] = nums[right];
                nums[right] = 2;
                while (nums[right] == 2) {
                    right--;
                }
                i--;
            }
        }
    }

    public static void main(String[] args) {
        SortColors obj = new SortColors();
        int[] array = {2, 0, 1};
        obj.sortColors(array);
    }
}
