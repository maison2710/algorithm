package leetcode;

public class LIS {
	public int lengthOfLIS(int[] nums) {
		if(nums.length==0){
			return 0;
		}
		int result = 1;
		int[] longestLengthArray = new int[nums.length];
		longestLengthArray[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			longestLengthArray[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]
						&& longestLengthArray[i] < longestLengthArray[j] + 1) {
					longestLengthArray[i] = longestLengthArray[j] + 1;
				}
			}
			if (result < longestLengthArray[i]) {
				result = longestLengthArray[i];
			}
		}

		return result;
	}

	public static void main(String[] args) {
		LIS lis = new LIS();
		int[] arr = {3, 7, 40, 80};
		System.out.println(lis.lengthOfLIS(arr));
	}
}
