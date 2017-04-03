package leetcode;

public class HouseRobberII {
	public int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		return Math.max(robLinear(nums, 0, nums.length - 2),
				robLinear(nums, 1, nums.length - 1));
	}

	public int robLinear(int[] nums, int start, int end) {
		int result = 0;
		if (start == end) {
			return nums[start];
		}
		int a = nums[start];
		int b = Math.max(nums[start], nums[start + 1]);
		result = Math.max(a, b);

		for (int i = start + 2; i <= end; i++) {
			int tmp = Math.max(nums[i] + a, b);
			a = b;
			b = tmp;
			if (result < tmp) {
				result = tmp;
			}
		}

		return result;
	}
}
