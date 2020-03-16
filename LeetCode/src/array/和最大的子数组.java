package array;

public class 和最大的子数组 {
	public static int maxSubarraySum(int[] A) {
		int max=A[0];
		int[] dp=new int[A.length];
		dp[0]=A[0];
		for(int i=1;i<A.length;i++){
			dp[i]=Math.max(dp[i-1]+A[i], A[i]);
			if(dp[i]>max)
				max=dp[i];
		}
		return max;
        
    }
	public static int maxSubarraySum2(int[] A) {
		int max=A[0];
		int sum=A[0];
		for(int i=1;i<A.length;i++){
			if(sum+A[i]<A[i]){
				sum=A[i];
			}else {
				sum+=A[i];
			}
			if (sum>max) {
				max=sum;
			}
		}
		
		return max;
	}
	public static int maxSubarraySum3(int[] A) {
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
	public static void main(String[] args) {
		int[] A={-2,1,-3,4,-1,2,1,-5,4};
		
		System.out.println(maxSubarraySum3(A));
	}
}
