package leetcode;

public class JumpGame {
	public boolean canJump(int[] nums) {
		int reach = 0;

		for (int i = 0; i < nums.length; i++) {
			if (i > reach) {
				return false;
			}
			reach = Math.max(nums[i] + i, reach);
		}
		return true;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 2, 1, 0, 4 };
		JumpGame obj = new JumpGame();
		System.out.println(obj.canJump(arr));
	}
}
