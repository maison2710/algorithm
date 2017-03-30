package leetcode;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int previous = nums[0];
		int current;
		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (previous < 0) {
				current = nums[i];
			} else {
				current = previous + nums[i];
			}
			previous = current;

			if (result < current) {
				result = current;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		MaximumSubarray obj = new MaximumSubarray();
		System.out.println(obj.maxSubArray(arr));
	}
}
