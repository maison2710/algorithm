package leetcode;

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
