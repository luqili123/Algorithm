package 基础算法;

public class 背包问题 {
	public static void main(String[] args){
		int[][] dp=new int[100][100];
		int[] value=new int[10];
		int[] w=new int[10];
		int i=0;
		int j=0;
		dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-w[i]]+value[i]);
	}
}
