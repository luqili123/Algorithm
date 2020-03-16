package dynamic_programming;

public class 买卖股票的最佳时机4 {
	//这种方法超时
	public static int maxProfit(int k, int[] prices) {
		int[][][] dp=new int[prices.length+1][k+1][2];
		for(int i=0;i<=k;i++){
			dp[0][i][0]=0;
			dp[0][i][1]=Integer.MIN_VALUE;
		}
		for(int i=1;i<=prices.length;i++){
			for(int j=1;j<=k;j++){
				dp[i][j][1]=Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i-1] );
				dp[i][j][0]=Math.max(dp[i-1][j][0], dp[i-1][j][1]+prices[i-1]);
			}
		}
        return dp[prices.length][k][0];
    }
	public static int maxProfit2(int k, int[] prices) {
//		一次交易由买入和卖出构成，至少需要两天。所以说有效的限制 k 应该不超过 n/2，如果超过，就没有约束作用了，相当于 k = +infinity。这种情况是之前解决过的。
		
		return 0;
    }
	public static void main(String[] args) {
		int[] prices={3,3,5,0,0,3,1,4};
		System.out.println(maxProfit(2, prices));
	}
}
