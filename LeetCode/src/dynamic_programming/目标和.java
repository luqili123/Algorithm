package dynamic_programming;

import java.util.Arrays;

public class 目标和 {

	public static int count = 0;

	// 递归
	public static int findTargetSumWays(int[] nums, int S) {
		count = 0;
		getSum(nums, 0, 0, S);
		return count;
	}

	public static void getSum(int[] nums, int index, int sum, int target) {
		if (index == nums.length) {
			if (sum == target) {
				count++;
			}
		} else {
			getSum(nums, index + 1, sum + nums[index], target);
			getSum(nums, index + 1, sum - nums[index], target);
		}
	}
	//动态规划
	public static int findTargetSumWays2(int[] nums, int S) {
		int sum=0;
		for (int i = 0; i < nums.length; i++) {
			sum+=nums[i];	
		}
		if((sum+S)%2==0){
			int target=(sum+S)/2;
			int[][] dp=new int[nums.length+1][target+1];
			for (int i = 0; i <nums.length+1; i++) {
				dp[i][0]=1;				
			}
			for (int i = 1; i < dp.length; i++) {
				for (int j = 1; j < dp[i].length; j++) {
					if(nums[i-1]<=j){
						dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i-1]];
					}else {
						dp[i][j]=dp[i-1][j];
					}				
				}
				
			}
			for (int i = 0; i < dp.length; i++) {
				for (int j = 0; j < dp[i].length; j++) {
					System.out.print(dp[i][j]+"  ");					
				}
				System.out.println();
				
			}
			return dp[nums.length][target];
		}else {
			return 0;
		}	
	}
	//空间优化
	public static int findTargetSumWays3(int[] nums, int S) {
		return S;
		
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 2, 1 };
		System.out.println(findTargetSumWays2(nums, 4));
	}
}
