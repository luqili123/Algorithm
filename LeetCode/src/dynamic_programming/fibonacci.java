package dynamic_programming;

public class fibonacci {
	public int Fibonacci(int n) {
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		else {
			return Fibonacci(n-1)+Fibonacci(n-2);
		}
    }
	//使用递归调用会有重复计算，动态规划将中间值存起来从而减少重复工作
	public int Fibonacci2(int n) {
		if(n<=1)
			return n;
		int[] fib=new int[n+1];
		fib[0]=0;
		fib[1]=1;
		for(int i=2;i<=n;i++){
			fib[i]=fib[i-1]+fib[i-2];
			System.out.println(fib[i]);
		}
		return fib[n];
	}
public static void main(String[] args) {
	fibonacci fibonacci =new fibonacci();
	System.out.println(fibonacci.Fibonacci2(4));;
}

}
