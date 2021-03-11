package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum
 * Medium
 * <p>
 * 3502
 * <p>
 * 109
 * <p>
 * Add to List
 * <p>
 * Share
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return result;
        }

        Arrays.sort(candidates);

        run(candidates, new ArrayList<Integer>(), target, 0);

        return result;

    }

    public void run(int[] candidates, List<Integer> values, int target, int index) {
        if (target == 0) {
            result.add(values);
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;
            } else {
                List<Integer> newValues = new ArrayList<>(values);
                newValues.add(candidates[i]);
                run(candidates, newValues, target - candidates[i], i);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        int[] candidates = {2, 3, 5};
        System.out.println(obj.combinationSum(candidates, 8));
    }
}
