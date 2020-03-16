package 剑指offer;
/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 
 * 输入: [7,1,5,3,6,4]
	输出: 5
	解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
	     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
	
	输入: [7,6,4,3,1]
	输出: 0
	解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

 * @author lqllq
 * 思路：https://blog.csdn.net/Conqueror_/article/details/103588601
 */
public class 股票的最大利润 {
	public int maxProfit(int[] prices) {
		//dp[i][j]，j等于0或1，表示到第i天时，若j=0代表，当前,未持有股票的最大收益，j=1表示当前持有股票的收益。、
		//因为只能交易一次，显然，若持有股票，收益肯定是1
		int[][] dp=new int[prices.length+1][2];
		dp[0][0]=0;
		dp[0][1]=-prices[0];
		
		for(int i=1;i<dp.length;i++){
			dp[i][1]=Math.max(dp[i-1][1], -prices[i-1]);
			dp[i][0]=Math.max(dp[i-1][0], dp[i-1][1]+prices[i-1]);
		}
		return dp[prices.length][0];
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}