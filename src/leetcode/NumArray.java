package leetcode;

public class NumArray {
	int[] nums;

	public NumArray(int[] nums) {
		this.nums = nums;

		for (int i = 1; i < nums.length; i++) {
			nums[i] = nums[i - 1] + nums[i];
		}
	}

	public int sumRange(int i, int j) {
		int result = 0;
		if (i < 0 || j >= nums.length || i > j) {
			return 0;
		}
		if (i == 0) {
			result = nums[j];
		} else {
			result = nums[j] - nums[i - 1];
		}

		return result;

	}

	public static void main(String[] args) {
		int[] arr = { -2, 0, 3, -5, 2, -1 };
		NumArray obj = new NumArray(arr);
		System.out.println(obj.sumRange(0, 2));
		System.out.println(obj.sumRange(2, 5));
		System.out.println(obj.sumRange(0, 5));
	}
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); int param_1 = obj.sumRange(i,j);
 */
