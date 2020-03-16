package dynamic_programming;

public class 打家劫舍 {
	public static int rob(int[] nums) {
		if(nums.length==0){
			return 0;
		}
		if(nums.length==1){
			return nums[0];
		}
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=nums[1];
        for(int i=2;i<nums.length;i++){
        	int max=Integer.MIN_VALUE;
        	for(int j=0;j<i-1;j++){
        		if(dp[j]>max){
        			max=dp[j];
        		}
        		dp[i]=max+nums[i];
        	}
        }
        return Math.max(dp[nums.length-1], dp[nums.length-2]);
    }
	
	
	public static int rob2(int[] nums) {
		if(nums.length==0){
			return 0;
		}
		if(nums.length==1){
			return nums[0];
		}
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0], nums[1]);
        for(int i=2;i<nums.length;i++){
        	dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
	public static void main(String[] args) {
		int[] nums={2,1,1,2};
		System.out.println(rob(nums));
		
	}
}
