package leetcode;

public class BestTimeSellBuyStock {
	public int maxProfit(int[] prices) {
		if (prices.length < 2) {
			return 0;
		}
		int min = prices[0];
		int result = 0;

		for (int i = 1; i < prices.length; i++) {
			result = Math.max(result, prices[i] - min);
			min = Math.min(min, prices[i]);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 7, 1, 5, 3, 6, 4 };
		BestTimeSellBuyStock obj = new BestTimeSellBuyStock();
		System.out.println(obj.maxProfit(arr));
	}
}
