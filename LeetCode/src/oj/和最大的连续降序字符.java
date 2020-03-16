package oj;

import java.util.Scanner;

/**
 * 思路：
 *  在给定的字符串中在任意位置选取任意个数的字符,这些字符必须满足它们之间的差相同,比如ABC,ACE, ACEG, BDFH
	将满足1的字符串中选取最长的某些字符串,比如 ACEG … BDFH等等
	在满足2的字符串中选取其ASC码最大的字符串比如BDFH
	将满足3的字符串逆序输出
	
	
	
	解法：
	因为可以从任意位置选取任意多的字符,所以首先将给定字符串转成减掉A后的ASC码,这样A对应0,B对应1…,Z对应25,并进行去重和排序
	创建数组,将给定的字符位置标记为1,没有的标记为0
	遍历数组,对标记为1的数,分别进行距离为1,2…k的探测,记录满足条件的数
	输出最佳答案
 * @author lqllq
 *
 */
public class 和最大的连续降序字符 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=Integer.parseInt(scanner.nextLine());
		while(t-->0){
			String str=scanner.nextLine();
			char[] temp=str.toCharArray();
			int[] arr=new int[temp.length];
			for(int i=0;i<temp.length;i++){
				arr[i]=temp[i]-48;
			}
			
		}
		
	}
}


















