package string;

public class ReverseInteger {
	//关键在于不能让倒过来的数超过整数最大值和最小值int
	//因为最大32位，一个符号位，所以其数值范围为 [−2^31,  2^31 − 1]，Integer.MAX_VALUE=2147483647，Integer.MIN_VALUE=-22147483648
	
	 public int reverse(int x) {
		 
		 int a=0;
		 while (x!=0) {
			 int pop=x%10;
			 System.out.print(pop+"  ");
			 if(a>Integer.MAX_VALUE/10||(a==Integer.MAX_VALUE/10&&pop>7))
				 return 0;
			 if(a<Integer.MIN_VALUE/10||(a==Integer.MIN_VALUE/10&&pop<-8))
				 return 0;
			 x=x/10;
			 a=a*10+pop;
		}
		 
		return a;}
	 public static void main(String[] args) {
		ReverseInteger reverseInteger=new ReverseInteger();
//		int x=2147483647;
		int x=-1221213;
		System.out.print(reverseInteger.reverse(x));
		
	}
}
