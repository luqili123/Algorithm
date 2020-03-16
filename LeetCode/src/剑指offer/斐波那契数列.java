package 剑指offer;

public class 斐波那契数列 {
	public int fib(int n) {
        long[] dp=new long[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            
            dp[i]=dp[i-1]+dp[i-2];
        }
        return  (int) (dp[n]%(1000000007));
    }
}
