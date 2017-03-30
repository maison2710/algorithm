package leetcode;

public class HouseRobber {
	public int rob(int[] nums) {
		int result = 0;
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int a = nums[0];
		int b = max(nums[0], nums[1]);
		result = max(a, b);

		for (int i = 2; i < nums.length; i++) {
			int tmp = max(nums[i] + a, b);
			a = b;
			b = tmp;
			if (result < tmp) {
				result = tmp;
			}
		}

		return result;
	}

	private int max(int i, int j) {
		if (i >= j) {
			return i;
		} else {
			return j;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 0, 3, 9, 5, 1 };
		HouseRobber obj = new HouseRobber();
		System.out.println(obj.rob(arr));
	}
}
