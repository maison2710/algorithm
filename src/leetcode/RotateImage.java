package leetcode;

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i; j < matrix.length - 1 - i; j++) {
                int row = i;
                int column = j;
                int buffer = matrix[row][column];

                for (int num = 0; num < 4; num++) {
                    int targetRow = matrix.length - 1 - (matrix.length - 1 - column);
                    int targetColumn = matrix.length - 1 - row;

                    int tmp = matrix[targetRow][targetColumn];
                    matrix[targetRow][targetColumn] = buffer;
                    buffer = tmp;

                    row = targetRow;
                    column = targetColumn;
                }

            }
        }

    }
}
