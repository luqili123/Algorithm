package math;

public class Print1ToMaxOfNDigits {
	//用字符模拟加法
	public void print1ToMaxOfNDigits(int n) {
		if(n<=0)
			return ;
		char[] number=new char[n];
		//初始化数组，默认都为'0'
		for (int i = 0; i < number.length; i++) {
			number[i]='0';
		}
		//如果没有溢出，就一直打印
		while(!increase(number))
			printNumber(number);
		
	}
	//实现字符的加法，溢出时返回true
	private boolean increase(char[] number) {
		boolean isOverflow=false;//溢出标志位
		int isCarry=0;//进位标志位
		int nLength=number.length-1;
		//从最后一位，也就是最低位开始遍历
		for(int i=nLength;i>=0;i--){
			int num=number[i]-'0'+isCarry;//现将字符转换成整型，如果进位标志位为1，则要加1
			//此时位于最低位，每次都是最低位加1
			if(i==nLength)
				num++;
			//每位数组都在0~9之间，加一之后大于等于10说明需要进位
			if(num>=10){
				//如果此时已经遍历到了最高位，再进位就会溢出
				if(i==0)
					isOverflow=true;
				//若未到最高位，则需要进位
				else {
					num=num-10;
					isCarry=1;
					number[i]=(char) (num+'0');
				}
			}
			//若不需要进位，就把原本的值在填回去
			else {
				number[i]=(char) (num+'0');
				break;//一次加一操作完成，此时不需要再往前循环了，所以应该跳出循环，打印数组
			}
		}
		return isOverflow;
	}
	private void  printNumber(char[] number) {
		boolean isZero=true;
		for (int i = 0; i < number.length; i++) {
			if(isZero&&number[i]!='0'){
				isZero=false;
			}
			if(!isZero)
				System.out.print(number[i]);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int n=3;
		Print1ToMaxOfNDigits pt1=new Print1ToMaxOfNDigits();
		pt1.print1ToMaxOfNDigits(n);
	}
}
