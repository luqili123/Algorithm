package dynamic_programming;

public class 买股票的最佳时机 {
	public static int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length+1][2];
        dp[0][1]=Integer.MIN_VALUE;
        dp[0][0]=0;
        for(int i=1;i<dp.length;i++){
        	dp[i][1]=Math.max(dp[i-1][1], -prices[i-1]);
        	dp[i][0]=Math.max(dp[i-1][0], dp[i-1][1]+prices[i-1]);
        }
        return dp[prices.length][0];
    }
	public static void main(String[] args) {
		int[] prices={7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
		
	}
}
