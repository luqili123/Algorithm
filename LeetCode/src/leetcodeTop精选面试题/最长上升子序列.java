package leetcodeTop精选面试题;
/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
	示例:
	输入: [10,9,2,5,3,7,101,18]
	输出: 4 
	解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * @author lqllq
 *
 */
public class 最长上升子序列 {
	public int lengthOfLIS(int[] nums){
		if(nums.length<2){
			return nums.length;
		}
		int[] dp=new int[nums.length];
		//子序列最小就是1
		for(int i=0;i<dp.length;i++){
			dp[i]=1;
		}
		int max=1;
		for(int i=1;i<dp.length;i++){
			for(int j=0;j<i;j++){
				//从0到i位置遍历，遇到比nums[i]小的元素，就代表当前i位置数字可以接到j位置元素的后面，但满足条件的不知一个位置，要找出其中最大的
				if(nums[i]>nums[j]){
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
			if(dp[i]>max){
				max=dp[i];
			}
		}
		return max;
		
	}
}
