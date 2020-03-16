package dynamic_programming;

public class MaxSubArray {
public int maxSubArray(int[] nums) {
//时间复杂度O(n^2)
//	int maxSum=Integer.MIN_VALUE,temp;
//	for(int i=0;i<nums.length;i++){	
//		temp=0;
//		for(int j=i;j<nums.length;j++){			
//			
//			temp=temp+nums[j];
//				if(temp>maxSum)
//					maxSum=temp;
//		}
//	}
//	return maxSum;
/*
 * 动态规划：O(n)
 * 设sum[i]为以第i个元素结尾且和最大的连续子数组。假设对于元素i，所有以它前面的元素结尾的子数组的长度都已经求得，
 * 那么以第i个元素结尾且和最大的连续子数组实际上，要么是以第i-1个元素结尾且和最大的连续子数组加上这个元素，要么是
 * 只包含第i个元素，即sum[i] = max(sum[i-1] + a[i], a[i])。可以通过判断sum[i-1] + a[i]是否大于a[i]来做选
 * 择，而这实际上等价于判断sum[i-1]是否大于0。由于每次运算只需要前一次的结果，因此并不需要像普通的动态规划那样保
 * 留之前所有的计算结果，只需要保留上一次的即可，因此算法的时间和空间复杂度都很小
 * */       
	int sum=nums[0];
	int n=nums[0];
	for(int i=1;i<nums.length;i++){
		if(n>0)n+=nums[i];
		else {
			n=nums[i];
		}
		if(sum<n)sum=n;
		
	}
	return sum;
    }
public static void main(String[] args) {
	MaxSubArray maxSubArray=new MaxSubArray();
	int[] nums={-2,1,-3,4,-1,2,1,-5,4};
	System.out.println(maxSubArray.maxSubArray(nums));
}
}
