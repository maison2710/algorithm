package leetcode;

import java.util.*;

/**
 * Combination Sum II
 * Medium
 * <p>
 * 1593
 * <p>
 * 63
 * <p>
 * Add to List
 * <p>
 * Share
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class CombinationSumII {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return result;
        }

        Arrays.sort(candidates);

        run(candidates, new ArrayList<Integer>(), target, 0);

        return result;
    }

    public void run(int[] candidates, List<Integer> values, int target, int baseIndex) {

        if(target < 0)
            return;

        if (target == 0) {
            result.add(values);
        }

        for (int i = baseIndex; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }

            if(i > baseIndex && candidates[i] == candidates[i - 1]){
                continue;
            }

            List<Integer> newValues = new ArrayList<>(values);
            newValues.add(candidates[i]);
            run(candidates, newValues, target - candidates[i], i + 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumII obj = new CombinationSumII();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(obj.combinationSum2(candidates, 8));
    }
}
