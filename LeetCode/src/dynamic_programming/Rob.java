package dynamic_programming;

public class Rob {
/*
 * 动态规划
 * f[i]=max(nums[i]+f[i-2],f[i-1])*/
public int rob(int[] nums) {
	int n=nums.length,max=0;
	if(n==0)return 0;
	if(n==1)return nums[0];
	if(n==2)return Math.max(nums[1], nums[0]);
	int pre1=Math.max(nums[1], nums[0]),pre2=nums[0];
	for(int i=2;i<nums.length;i++){
		 max=Math.max(nums[i]+pre2, pre1);
		 pre2=pre1;
		 pre1=max;
	}
	return pre1;
        
    }
public static void main(String[] args) {
		Rob rob=new Rob();
		int[] nums={2,7,9,3,1};
		System.out.println(rob.rob(nums));
		
}
}
