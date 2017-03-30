package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
		Map<Integer, Integer> modMap = new HashMap<Integer, Integer>();
		int modSum = 0;
		modMap.put(0, -1);

		for (int i = 0; i < nums.length; i++) {
			modSum += nums[i];
			if (k != 0)
				modSum %= k;
			Integer prev = modMap.get(modSum);
			if (prev != null) {
				if (i - prev > 1)
					return true;
			} else {
				modMap.put(modSum, i);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 6, 7 };
		ContinuousSubarraySum obj = new ContinuousSubarraySum();
		System.out.println(obj.checkSubarraySum(arr, 6));
	}

}
