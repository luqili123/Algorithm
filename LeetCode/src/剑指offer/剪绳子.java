package 剑指offer;
/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。
 * 请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * @author lqllq
 *思路：当绳子长度为1时，只能分割1，为2是若分成2个1则成乘积反而变小，所以不分割，为3是同理，为4的时候，分成2*2可以保底，其他都会变小。
 *当大于4之后，所有的数只有分割才会乘积更大，而由于前面的分析，我们知道，当分割到3的时候就不能再分割了，因为在分割乘积就会变小，所以，
 *我们把数字分割成尽量多的3，若最后剩下的数小于等于4则不拆分，否则继续拆除一个3
 */
public class 剪绳子 {
	public static int cuttingRope(int n) {
		if(n == 2) {
            return 1;
    }
    if(n == 3){
        return 2;
    }
    long res = 1;
    while(n > 4) {
        res *= 3;
        n -= 3;
    }
    return (int)res * n ;

		
    }
	public static int cuttingRope2(int n) {
		if(n == 2) {
	            return 1;
	    }
        if(n == 3){
            return 2;
        }
        int mod = (int)1e9 + 7;
        long res = 1;
        while(n > 4) {
            res *= 3;
            res %= mod;
            n -= 3;
        }
        return (int)(res * n % mod);

		
    }
	public static void main(String[] args){
		System.out.println(cuttingRope(120));
		System.out.print(cuttingRope2(120));
	}
}
