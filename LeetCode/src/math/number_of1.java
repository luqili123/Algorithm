package math;

public class number_of1 {
	 public int NumberOf1(int n) {
		 //n       : 10110100
		 //n-1     : 10110011
		 //n&(n-1) : 10110000
		 //每进行一次与运算，就会减少一个1，当n为0时，与运算的次数就是1的个数
		 int count=0;
		 while(n!=0){
			 n=n&(n-1);
			 count++;
		 }
		 return count;
		 
	 }
}
