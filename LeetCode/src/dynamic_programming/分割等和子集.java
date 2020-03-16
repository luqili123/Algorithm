package dynamic_programming;

public class 分割等和子集 {
	public static boolean canPartition(int[] nums) {
		int sum=0;
		for(int i=0;i<nums.length;i++){
			sum+=nums[i];
		}
		if(sum%2!=0||nums.length<2){
			return false;
		}
        int[][] dp=new int[nums.length+1][(sum/2)+1];
        for(int i=1;i<dp.length;i++){
        	for(int j=1;j<dp[i].length;j++){
        		if(nums[i-1]<=j){
        			dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-nums[i-1]]+nums[i-1]);
        		}else {
					dp[i][j]=dp[i-1][j];
				}
        		if(dp[i][j]==sum/2){
        			return true;
        		}
        	}
        }
//        for (int i = 0; i < dp.length; i++) {
//			for (int j = 0; j < dp[i].length; j++) {
//				System.out.print(dp[i][j]+" ");			
//			}
//			System.out.println();
//			
//		}
        
        return false;
    }
	//空间优化
	public boolean canPartition2(int[] nums) {
		
        return false;
    }
	public static void main(String[] args) {
		int[] nums={1,2,3,4,5};
		System.out.println(canPartition(nums));
	}
}
