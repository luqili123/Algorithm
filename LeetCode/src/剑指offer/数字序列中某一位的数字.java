package 剑指offer;
/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 * @author lqllq
 *	规律：一位的数字有9个，占9个位置，两位的数字占2*90个位置，三位数字3*900个位置，n位数字占n*9*10^(n-1)
 *
 *	思想：首先应该根据n确定第n个字符是在几位数的范围之内，假设在x位数字的范围之内，然后减去x-1位数字的长度，剩下的就是x位数字的长度y，y/x就可以知道他是
 *  第几个数字，再求余y%x得到他是x位中的第几位
 */
public class 数字序列中某一位的数字 {
    public static int findNthDigit(int n) {
    	
    	if(n<0||n==0){
    		return n;
    	}
    	long t=n;
    	//记录n在几位数的范围内
    	long len=1;
    	long x=10;
    	while(t-x>0){
    		len++;
    		//减掉前面len-1位的数字的长度
    		t-=x;
    		x=(long) (len*9*Math.pow(10, len-1));
    	}
    	
    	int index=(int) (t%len);
    	//计算出n所在位置的真实数字
    	String num=null;
    	if(len==1){
    		//长度为1不需要加10的幂
    		 num=(long)(t-index)/len+"";
    	}else{
    		 //不转换成long类型,字符串会变成科学计数法
    		 num=(long)(Math.pow(10, len-1)+(t-index)/len)+"";
    	}  	
    	return num.charAt(index)-'0';
  	
    }
    public static void main(String[] args){
    	System.out.println(findNthDigit(999999999));
    	System.out.print(Integer.MAX_VALUE);
    }
}