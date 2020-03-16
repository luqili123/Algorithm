package array;

public class 环型子数组最大和 {
	public static int maxSubarraySumCircular(int[] A) {
		int sum=0;
		//求出所有元素之和
		for (int i = 0; i < A.length; i++) {
			sum+=A[i];
		}
		//有环的子数组最大和相当三种情况：1.不考虑环时子数组最大和 2.所有元素和除去子数组最小和的值3.所有元素和
		int max=maxSubarraySum(A);
		int min=minSubarraySum(A);
		
		System.out.println("max="+max);
		System.out.println("min="+min);
		System.out.println("sum="+sum);
		//最小子数组和与sum相等代表最小子数组就是数组本身，所以此时返回最大子数组和
		if(sum==min){
			return max;
		}else {
			return min>0?sum:Math.max(max, sum-min);
		}
        
    }
	//求出不考虑环时的子序列最大和
	public static int maxSubarraySum(int[] A){
		int max=Integer.MIN_VALUE;
		int sum=0;
		for (int i = 0; i < A.length; i++) {
			max=Math.max(max, sum+A[i]);
			if(sum+A[i]>0){
				sum+=A[i];
			}else {
				sum=0;
			}
		}
		return max;
	}
	//求出不考虑环时的子序列最小和
	public static int minSubarraySum(int[] A){
		int min=Integer.MAX_VALUE;
		int sum=0;
		for (int i = 0; i < A.length; i++) {
			min=Math.min(min, sum+A[i]);
			if(sum+A[i]<0){
				sum+=A[i];
			}else {
				sum=0;
			}
		}
		return min;
	}
	public static void main(String[] args) {
		int[] A={-2,-3,-1};
		System.out.println(maxSubarraySumCircular(A));
	}
}
