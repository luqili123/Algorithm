package dynamic_programming;

import java.util.Arrays;

public class 摆动子序列 {
	public int wiggleMaxLength(int[] nums) {
		if(nums.length<2){
			return nums.length;
		}
		int[] dp=new int[nums.length];
		Arrays.fill(dp, 2);
		int j,temp=nums[1]=nums[0];
		
		return 0;
        
    }
}
