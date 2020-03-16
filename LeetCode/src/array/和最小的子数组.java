package array;

public class 和最小的子数组 {
	public static int minSubarraySum(int[] A) {
		int min=Integer.MAX_VALUE;
		int sum=0;
		for (int i = 0; i < A.length; i++) {
			min=Math.min(min,sum+A[i]);
			if(sum+A[i]<0){
				sum+=A[i];
			}else {
				sum=0;
			}
		}
		return min;
		
	}
	public static void main(String[] args) {
		int[] A={1,-2,3,4,-5,10,-2};
		System.out.println(minSubarraySum(A));
	}
}
