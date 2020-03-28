package leetcodeTop精选面试题;

public class 字符串转整数 {
	public static int myAtoi(String str) {
		//去除首尾空格
		str=str.trim();
		if(str.length()==0){
			return 0;
		}
		int len=str.length();
		int sign=1;
		int i=0;
		//检查开头字符
		if(str.charAt(i)=='-'){
			sign=-1;
		}
		if(str.charAt(i)=='-'||str.charAt(i)=='+'){
			i++;
		}
		int num=0;
		while(i<len&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
			//获取到整数值
			int temp=str.charAt(i)-48;
			//边界判断，正整数最大值2147483647，在取到最后一位的时候判端，即当前数字大于214748364或当前数字等于214748364且取到的数大于7
			if(sign==1&&(num>214748364||(num==214748364&&temp>=7))){
				return 2147483647;
			}
			//边界判断，负整数最小值为-2147483648，判断方法和上面相同
			if(sign==-1&&(-num<-214748364||(-num==-214748364&&temp>=8))){
				return -2147483648;
			}
			num=num*10+temp;
			i++;
		}
		
		return num*sign;
    }
	 public static void main(String[] args){
		 String s="   ";
		 
		 System.out.print(myAtoi("-sadsad9128347sdas dasd2332"));
	 }
}
