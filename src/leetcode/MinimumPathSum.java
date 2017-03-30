package leetcode;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int row = grid.length;
		int column = grid[0].length;

		int[][] minMatrix = new int[row][column];
		minMatrix[0][0] = grid[0][0];

		for (int i = 1; i < column; i++) {
			minMatrix[0][i] = minMatrix[0][i - 1] + grid[0][i];
		}

		for (int i = 1; i < row; i++) {
			minMatrix[i][0] = minMatrix[i - 1][0] + grid[i][0];
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				int prev = min(minMatrix[i - 1][j], minMatrix[i][j - 1]);
				minMatrix[i][j] = grid[i][j] + prev;
			}
		}

		return minMatrix[row - 1][column - 1];
	}

	private int min(int a, int b) {
		if (a <= b) {
			return a;
		} else {
			return b;
		}
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 2 }, { 1, 1 } };
		MinimumPathSum obj = new MinimumPathSum();
		System.out.println(obj.minPathSum(arr));
	}
}
