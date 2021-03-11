package leetcode;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int count = 0;
		int pos = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				count++;
			} else {
				nums[pos] = nums[i];
				pos++;
			}
		}
		for (int i = 1; i <= count; i++) {
			nums[pos] = 0;
			pos++;
		}
	}
}
