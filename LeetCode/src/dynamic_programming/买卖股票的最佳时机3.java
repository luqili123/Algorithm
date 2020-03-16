package dynamic_programming;

public class 买卖股票的最佳时机3 {
	public static int maxProfit(int[] prices) {
		int k=2;
        int[][][] dp=new int[prices.length+1][k+1][2];
        for(int i=0;i<k+1;i++){
        	dp[0][i][0]=0;
        	dp[0][i][1]=Integer.MIN_VALUE;
        }       
        for(int i=1;i<dp.length;i++){
        	for(int j=1;j<k+1;j++){
        		dp[i][j][0]=Math.max(dp[i-1][j][0], dp[i-1][j][1]+prices[i-1]);
            	dp[i][j][1]=Math.max(dp[i-1][j][1], dp[i-1][j-1][0]-prices[i-1]);
        	}
        }
        return dp[prices.length][2][0];
    }
	public static void main(String[] args) {
		int[] prices={1,2,3,4,5};
		System.out.println(maxProfit(prices));
	}
}
