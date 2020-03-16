package oj;

import java.util.Scanner;
/**
100 99 98 1 2 3
1 2 3 4 5 40
1 5 5 7 14
4 5 7 7 9
5 5 9 9 1
4 7 7 8 5
1 3 4 5
8 9 19 21
12 25 98 78
67 37 92 23

 * 
 * 
 * 
 * @author lqllq
 *
 */

public class 调整数组使差最小2 {
	public  static int min=Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=Integer.parseInt(scanner.nextLine());
		for(int k=0;k<n;k++){
			
			String[] temp=(scanner.nextLine()+" "+scanner.nextLine()).split(" ");
			int len=temp.length;
			int[] array=new int[len];
			int sum=0;
			for(int i=0;i<len;i++){			
				array[i]=Integer.parseInt(temp[i]);
				sum+=array[i];//计算所有元素之和
			}
//			System.out.println("所有元素和为"+sum);
//			System.out.println("所有元素和的一半"+sum/2);
			int valMax=sum/2;		
			MinArray(array, 0, 0,0,valMax);
			if (k == n - 1)
				System.out.print(min*2);
			else
				System.out.println(min*2);
			min=Integer.MAX_VALUE;
		}
	}
	/**
	 * 
	 * @param array:元素数组
	 * @param i :前i个元素中被选择的元素的和
	 * @param sum ：n个元素的和
	 * @param n ：已经选择几个元素求和
	 */
	public static void MinArray(int[] array,int i,int subsum,int n,int valMax){
		if(i==array.length){
			if(n==array.length/2){
				System.out.print(subsum+" ");
				int val=Math.abs(subsum-valMax);
				if(val<min)
					min=val;
			}		
		}else {
			MinArray(array, i+1, subsum, n,valMax);
			MinArray(array, i+1, subsum+array[i], n+1,valMax);
		}
		
			
		
	}
}
