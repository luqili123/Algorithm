package 剑指offer;
/**
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
 * @author lqllq
 * 动态规划：dp[i]代表：以nums[i]结尾的子数组的最大值
 * 每个位置上的元素要么接着前一个数组，要么另起炉灶
 */
public class 连续子数组的最大和 {
	
	public int maxSubArray(int[] nums) {
		int[] dp=new int[nums.length];
		dp[0]=nums[0];
		int max=dp[0];
		for(int i=1;i<dp.length;i++){
			dp[i]=Math.max(dp[i-1]+nums[i], nums[i]);
			if(dp[i]>max){
				max=dp[i];
			}
		}
		return max;
    }
}
