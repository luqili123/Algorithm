package dynamic_programming;

public class 整数拆分 {
	public static void main(String[] args) {
		System.out.println(integerBreak2(12));
	}
	public static int integerBreak(int n) {
		int result=1;
		if(n==2){
			return 1;
		}
		if(n==3){
			return 2;
		}
        while(n>=3){
        	if(n==4){
        		return result*4;
        	}else {
				result=result*3;
				n=n-3;
			}

        }
        if(n!=0){
        	return result*n;
        }else {
			return result;
		}
    }
	public static int integerBreak2(int n) {
		if(n<=3){
			return n-1;
		}
		int a=n/3;
		int b=n%3;
		if(b==0){
			return (int) Math.pow(3, a);
		}
		if(b==1){
			return (int) (Math.pow(3, a-1)*4);
		}
		if(b==2){
			return (int) (Math.pow(3, a)*2);
		}else {
			return 0;
		}
	}

}
