package dynamic_programming;

public class MaxProfit {
	 public int maxProfit(int[] prices) {
		 int maxprofit=0,temp=0;
		 for(int i=0;i<prices.length-1;i++){
			 for(int j=i+1;j<prices.length;j++){
				  temp=prices[j]-prices[i];
				 if(temp>maxprofit)
					 maxprofit=temp;
			 }
		 }
		return maxprofit;
	        
	    }
	 public static void main(String[] args) {
		MaxProfit maxProfit=new MaxProfit();
		int[] prices={7,1,5,3,6,4};
		System.out.print(maxProfit.maxProfit(prices));
		
	}
}
