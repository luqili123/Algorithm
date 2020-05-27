package 剑指offer;

public class x的平方根 {
	public static int mySqrt(int x) {
		if(x<0){
			return -2;
		}
		if(x==0||x==1){
			return x;
		}
		long left=0;
		long right=x/2;
		while(left<right){
			long mid=(left+right+1)/2;
			long squ=mid*mid;
			if(squ>x){
				right=mid;
			}else{
				left=mid;
			}
		}
		return (int) left;
		
	}
	

	public static void main(String[] args){
		System.out.println(mySqrt(5));
		;
	}
}
