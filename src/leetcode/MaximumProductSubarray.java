package leetcode;

public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int maxPrev = nums[0];
		int minPrev = nums[0];
		int max = nums[0];
		int maxCurrent, minCurrent;

		for (int i = 1; i < nums.length; i++) {
			maxCurrent = Math.max(
					Math.max(maxPrev * nums[i], minPrev * nums[i]), nums[i]);
			minCurrent = Math.min(
					Math.min(maxPrev * nums[i], minPrev * nums[i]), nums[i]);
			max = Math.max(maxCurrent, max);
			maxPrev = maxCurrent;
			minPrev = minCurrent;

		}

		return max;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 2, 4 };
		MaximumProductSubarray obj = new MaximumProductSubarray();
		System.out.println(obj.maxProduct(arr));
	}
}
