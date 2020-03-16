package 剑指offer;
//请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
//https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
public class 二进制中1的个数 {
	 // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	//循环判断最后一位是否为1
    	int count=0;
    	int t=0;
    	while(n!=0){
    		if((n&1)==1){
    			count++;		
    		}
    		//逻辑右移，高位补0
			n=n>>>1;  
    		
    	}
    	return count;  	
    }
}
