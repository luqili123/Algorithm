package array;

public class MaxProfit {
	 public int maxProfit(int[] prices) {
		 int maxprofit=0,tmp=0;
		 for(int i=1;i<prices.length;i++){
			 tmp=prices[i]-prices[i-1];
			 if(tmp>0)
				 maxprofit+=tmp;
			 
		 }
		return maxprofit;
	        
	    }
	 public static void main(String[] args){
		 
	 }
}
