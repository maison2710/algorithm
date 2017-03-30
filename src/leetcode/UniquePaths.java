package leetcode;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		int[][] ways = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (j == 0 || i == 0) {
					ways[i][j] = 1;
				} else {
					ways[i][j] = ways[i - 1][j] + ways[i][j - 1];

				}
			}
		}
		return ways[m - 1][n - 1];
	}

	public static void main(String[] args) {
		UniquePaths obj = new UniquePaths();
		System.out.println(obj.uniquePaths(2, 3));
	}
}
