
public class MaxProfit {
	//：贪心算法，总是做出在当前看来是最好的选择，不从整体最优上加以考虑，也就是说，只关心当前最优解
	public int maxProfit(int[] prices) {
		int maxprofit=0,tmp=0;
		 for(int i=1;i<prices.length;i++){
			 tmp=prices[i]-prices[i-1];
			 if(tmp>0)
				 maxprofit+=tmp;
			 
		 }
		return maxprofit;
		
	}
	public static void main(String[] args) {
		MaxProfit maxProfit=new MaxProfit();
		int[] nums={1,2,3,3,4,10};
		System.out.println(maxProfit.maxProfit(nums));
	}
}
