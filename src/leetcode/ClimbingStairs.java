package leetcode;

public class ClimbingStairs {
	public int climbStairs(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int prev2 = 1;
		int prev1 = 1;
		int current = 2;

		for (int i = 2; i <= n; i++) {
			current = prev2 + prev1;
			prev2 = prev1;
			prev1 = current;
		}

		return current;
	}

	public static void main(String[] args) {
		ClimbingStairs obj = new ClimbingStairs();
		System.out.println(obj.climbStairs(4));
	}
}
