package dynamic_programming;

import java.util.Arrays;

public class 最长上升子序列 {
	public static int lengthOfLIS(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int max = -1;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 6, 7, 9, 4, 10, 5, 6 };

		System.out.println(lengthOfLIS(nums));
	}
}
