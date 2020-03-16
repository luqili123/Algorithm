package dynamic_programming;

public class 等差数列划分 {
	//双指针
	public static int numberOfArithmeticSlices(int[] A) {
		int num = 0;
		int i = 0;
		int j = 1;
		while (i < A.length - 2 && j < A.length) {
			int differ = A[i + 1] - A[i];
			int count = 0;
			for (j = i + 1; j < A.length; j++) {
				if (A[j] - A[j - 1] == differ) {
					count++;
				} else {
					i = j - 1;
					break;
				}
			}
			if (count >= 2) {
				num += count * (count - 1) / 2;
			}
		}
		return num;

	}
	//动态规划
	public static int numberOfArithmeticSlices2(int[] A) {
		if(A.length<=0){
			return 0;
		}
		int[] dp=new int[A.length];
		int num=0;
		dp[0]=0;
		dp[1]=0;
		for(int i=2;i<A.length;i++){
			if(A[i]-A[i-1]==A[i-1]-A[i-2]){
				dp[i]=dp[i-1]+1;
			}
			num+=dp[i];
		}
		return num;
		
	}
	//优化空间，dp[i]只和dp[i-1]有关，只需要一个变量保存即可
	public static int numberOfArithmeticSlices3(int[] A) {
		if(A.length<=0){
			return 0;
		}
		int dp=0;
		int num=0;
		
		for(int i=2;i<A.length;i++){
			if(A[i]-A[i-1]==A[i-1]-A[i-2]){
				dp=dp+1;
			}else {
				dp=0;
			}
			num+=dp;
		}
		return num;
		
	}

	public static void main(String[] args) {
		int[] A = { 1,2,3,4,5,6 };
		System.out.println(numberOfArithmeticSlices3(A));
	}
}
