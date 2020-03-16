package 剑指offer;
/**
 * 本题主要是找规律。暴力算法会超时。
我们先来看一个简单的规律：
设f(n)是只从0到n位数的最大值一共有多少个1，
f(1) = 计算0~9有多少个1 = 1；
f(2) = 计算0~99有多少个1；

我们先把1开头的十位数单独拿出来考虑且只考虑十位数上1的个数：10~19共有10个1；
然后再考虑个位数上1的个数，此时十位数范围从0~9，每种十位数对应1个个数均为f(1);
综合得f(2) = 10 + 10 * f(1) = 20;
同理 f(3) = 计算0~999有多少个1

先把1开头的百位数单独拿出来考虑，且只考虑百位数：100~199，共100个1；
再考虑其他位数上1的个数，此时百位数范围从0~9，每种百位数对应1个数均为f(2);
综合得 f(3) = 100 + 10 * f(2) = 300;
针对题目中数字最大为2^31次方，最多只有10位数。所以综上所述我们可以列出f(n)
f(1) = 1;
f(2) = 20;
f(3) = 300;
f(4) = 4000;
f(5) = 50000;
f(6) = 600000;
f(7) = 7000000;
f(8) = 80000000;
f(9) = 900000000;
f(10) = ‭10,000,000,000‬;

但给的n不可能正好是100,1000,还得从一般情况下考虑。
从个位数开始,h(x)代表n为x当前位上1出现的次数：
1.个位数：若个位数为0，则个位出现1的个数由它的更高位决定。例如：h(30)=3*1，h(300)=30*1,h(350)=35*1
		 若个位数为1，那么和0相比，它只多了一个。例如：h(31)=3*1+1,h(301)=30*1+1
		 若个位数大于1，和上面的情况相同。例如：h(32)=3*1+1,h(302)=30*1+2;
		 
十位数：若为0，由更高位决定。例如：h(100)=10*1,h(200)=2*10,h(1000)=10*10
	 	若为1，则由高位和低位共同决定：例如：h(110)=1*10+1,h(212)+2*10+3,h(2012)=20*10+3
	 	若大于1，则（高位+1）*10^m:例如：h(120)=(1+1)*10,h(220)=(2+1)*10,h(2112)=(21+1)*10
	 	
	 	
百位，千位都类似	 	
总结：不管哪一位，都分成3种情况，等于0，等于1，大于1来讨论。
	其中：等于0，该位1个数由高位决定，公式为   高位的数字*10^m，其中m右你是哪一位决定，当前位置是个位，那么m等于0，十位m等于1，以此类推
		     等于1，该位1个数由高位和低位一起决定，公式为：(高位的数字*10^m)+低位+1，例如：要算313十位会有几个1，那就是：3*10^1+3+1=34
		     大于1，此时该位1的个数还是由高位决定不过要要加一，公式为(g高位+1)*10^m,例如要算323十位上会有几个1，那就是(2+1)*10^m
			 
	
 * @author lqllq
 *
 */
public class 求1到n整数中1出现的次数 {
	public static int countDigitOne(int n) {
		if(n<0){
			return -1;
		}
		if(n==0||n==1){
			return n;
		}
		//现将整数变成字符串，方便拿取最高位
		String val=String.valueOf(n);
//		System.out.println(val);
		int count=0;
		int len=val.length();
		for(int i=len-1;i>=0;i--){
			//若当前位为0，则该位出现1的个数由更高位决定
			if(val.charAt(i)=='0'){
				//判断当前位置是否已经到达最高位，而0不可能是最高位，这里可以不考虑
				//若当前是最定位
				int temp=Integer.parseInt(val.substring(0,i));
				System.out.println(temp);
				count+=temp*Math.pow(10, len-i-1);
				
			}else if(val.charAt(i)=='1'){//当前位为1，则出现1的次数由高位和低位共同决定
				//判断当前位置是否已经到达最高位
				//已经是最高位了,没有更高位了，只需要考虑低位
				if(i==0){
					int low=Integer.parseInt(val.substring(i+1,len));
					count+=low+1;
				}else if(i==len-1){//若是最低位，则，只需考虑高位
					int high=Integer.parseInt(val.substring(0,i));
					count+=high*Math.pow(10, len-i-1)+1;
					
				}else{//当前不是最高位，需要获取高位和低位
					int high=Integer.parseInt(val.substring(0,i));
					int low=Integer.parseInt(val.substring(i+1,len));
					count+=high*Math.pow(10, len-i-1)+low+1;					
				}
				
			}else{//当前位大于1时，出现1的个数为（高位+1）10^x，x根据当前位置决定
				//已经是最高位了,没有更高位了，可以认为他的更高位为0
				if(i==0){
					count+=(0+1)*Math.pow(10, len-i-1);
				}else{
					int high=Integer.parseInt(val.substring(0,i));
					count+=(high+1)*Math.pow(10, len-i-1);
				}
			}
		}
		return count;
		
    }
	
	
	
	
	
	public static void main(String[] args){
		
		System.out.println(countDigitOne(11));
//		System.out.println(countDigitOne(13));
//		System.out.println(countDigitOne(33));
//		System.out.println(countDigitOne(123));
//		System.out.println(countDigitOne(2345));
//		System.out.println(countDigitOne(33));
//		System.out.println(countDigitOne(33));
//		System.out.println(countDigitOne(33));
	}
	
	
	
	
	
	
	
	
	
	
	
}
