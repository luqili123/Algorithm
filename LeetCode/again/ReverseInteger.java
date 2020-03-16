
public class ReverseInteger {
	 public int reverse(int x) {
		int result=0,b;
		while (x!=0) {
			b=x%10;
			if(result>Integer.MAX_VALUE/10||(result==Integer.MAX_VALUE/10&&b>7))
				return 0;
			if(result<Integer.MIN_VALUE/10||(result==Integer.MIN_VALUE/10&&b<-8))
				return 0;
			result=result*10+b;
			x/=10;
		}
		return result;
		 
	 }
	 public static void main(String[] args) {
		int a=-1999;
		System.out.println(a/10000);
		System.out.println(a%10);
		ReverseInteger reverseInteger=new ReverseInteger();
		System.out.println(reverseInteger.reverse(10000));
	}
}
