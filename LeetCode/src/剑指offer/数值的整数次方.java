package 剑指offer;
//实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
//https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
public class 数值的整数次方{
	//递归写法（二分法）
	public double myPow(double x, int n) {
		if(n==0){
			return 1;
		}
		if(x==1.0||n==1){
			return x;
		}
		//负数情况转化成正数处理
		if(n<0){
			return (1/x)*myPow(1/x,-(n+1));
		}
		//判断n是奇数还是偶数
		if((n&1)==0){
			//是偶数
			return myPow(x*2,n/2);
		}else{
			return  myPow(x*x,(n-1)/2)*x;
		}
	
    }
	//非递归
	//把指数 n 做“二进制分解”，在底数不断自身乘以自身的过程中，将最终结果需要的部分保存下来。
	//8=1*2^3+0*2^2+0*2^1+0*2^0
	//1和0可以根据移位得到，2的幂可以累积得到
	public double myPow2(double x, int n) {
		long N=n;
		if(n==0){
			return 1;
		}
		if(x==1.0||n==1){
			return x;
		}
		if(N<0){
			x=1/x;
			N=N*-1;
		}
		double res=1.0;
		while(N>0){
			if((N&1)==1){
				res*=x;
			}
			x=x*x;
			N=N>>>1;
		}
		return res;
	
    }
}
