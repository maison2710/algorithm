package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permutations {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return result;
        }

        permute(new ArrayList<Integer>(), nums);
        return result;
    }

    public void permute(List<Integer> permutation, int[] nums) {
        if (nums.length == 0) {
            result.add(permutation);
        } else {
            for (int i = 0; i < nums.length; i++) {
                List<Integer> newPermutation = new ArrayList<>(permutation);
                newPermutation.add(nums[i]);
                int[] newNums = new int[nums.length - 1];
                int index = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (j == i) {
                        continue;
                    } else {
                        newNums[index] = nums[j];
                        index++;
                    }
                }
                permute(newPermutation, newNums);
            }
        }
    }

    public static void main(String[] args) {
        Permutations obj = new Permutations();
        int[] array = {1, 2, 3};
        System.out.println(obj.permute(array));
    }
}
