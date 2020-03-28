package leetcodeTop精选面试题;

import java.util.HashMap;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。	
	字符          数值
	I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000
	例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
	
	通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
	所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
	
	I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
	X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
	C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
	给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

 * @author lqllq
 *
 */
public  class 罗马数字转整数 {
	
	/**
	 * 罗马数字由 I,V,X,L,C,D,M 构成；
	     当小值在大值的左边，则减小值，如 IV=5-1=4；
               当小值在大值的右边，则加小值，如 VI=5+1=6；
              由上可知，右值永远为正，因此最后一位必然为正。
              一言蔽之，把一个小值放在大值的左边，就是做减法，否则为加法。
              例如IV，初始sum=0，扫描到I发现比V小，则sum-1=-1，然后扫描到V没有比他小的，就sum+5=4;
	 * @param s
	 * @return
	 */
	 public static int romanToInt2(String s) {
		 if(s==null||s.equals("")){
			 return 0;
		 }
		 HashMap<Character,Integer> hash=new HashMap<>();
		 hash.put('I', 1);
		 hash.put('V', 5);
		 hash.put('X', 10);
		 hash.put('L', 50);
		 hash.put('C', 100);
		 hash.put('D', 500);
		 hash.put('M', 1000);
		 
		 int res=0;
		 int pre=hash.get(s.charAt(0));
		 for(int i=1;i<s.length();i++){
			 int curr=hash.get(s.charAt(i));
			 if(pre<curr){
				 res-=pre;
			 }else{
				 res+=pre;
			 }
			 pre=curr;
		 }
		 //加上最后一个数
		 res+=pre;
		 return res;
		 
	 }
	
	/**
	 * 太繁琐，可以简化
	 * @param s
	 * @return
	 */
	 public static int romanToInt(String s) {
		 if(s==null||s.equals("")){
			 return 0;
		 }
		 HashMap<Character,Integer> hash=new HashMap<>();
		 hash.put('I', 1);
		 hash.put('V', 5);
		 hash.put('X', 10);
		 hash.put('L', 50);
		 hash.put('C', 100);
		 hash.put('D', 500);
		 hash.put('M', 1000);
		 
		 int res=0;
		 int i=0;
		 int len=s.length();
		 while(i<len){
			 if(s.charAt(i)=='I'){
				 if(i+1<len&&s.charAt(i+1)=='V'){
					 res+=4;
					 i+=2;
				 }
				 else if(i+1<len&&s.charAt(i+1)=='X'){
					 res+=9;
					 i+=2;
				 }else{
					 res+=1;
					 i++;
				 }
			 }
			 else if(s.charAt(i)=='X'){
				 if(i+1<len&&s.charAt(i+1)=='L'){
					 res+=40;
					 i+=2;
				 }
				 else if(i+1<len&&s.charAt(i+1)=='C'){
					 res+=90;
					 i+=2;
				 }else{
					 res+=10;
					 i++;
				 }
			 }
			 else if(s.charAt(i)=='C'){
				 if(i+1<len&&s.charAt(i+1)=='D'){
					 res+=400;
					 i+=2;
				 }
				 else if(i+1<len&&s.charAt(i+1)=='M'){
					 res+=900;
					 i+=2;
				 }else{
					 res+=100;
					 i++;
				 }
			 }else{
				 res+=hash.get(s.charAt(i));
				 i++;
			 }
		 }
		 return res;
	 }
	 
	 
	 public static void main(String[] args){
		 System.out.print(romanToInt("XXIV"));
		 System.out.print(romanToInt2("XXIV"));
	 }
}
