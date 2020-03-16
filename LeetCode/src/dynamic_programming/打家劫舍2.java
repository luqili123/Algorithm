package dynamic_programming;

public class 打家劫舍2 {
	public static int rob(int[] nums) {
		if(nums.length==0){
			return 0;
		}
		if(nums.length==1){
			return nums[0];
		}
		if(nums.length==2){
			return Math.max(nums[0],nums[1]	 );
		}
		//去除了一个元素，dp数组长度也减少一个
		int[] dp=new int[nums.length-1];
		//去掉最后一间的情况
		dp[0]=nums[0];
		dp[1]=Math.max(nums[0], nums[1]);
		int res1,res2;
		for(int i=2;i<nums.length-1;i++){
			dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i]);
		}
		res1=dp[nums.length-2];
		//去掉第一间一间的情况
		dp[0]=nums[1];
		dp[1]=Math.max(nums[1], nums[2]);		
		for(int i=2;i<nums.length-1;i++){
			dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i+1]);
		}
		res2=dp[nums.length-2];
		//去两种情况最大值
		return Math.max(res1, res2);
    }
	public static void main(String[] args) {
		int[] nums={2,1,1};
		System.out.println(rob(nums));
	}
}
