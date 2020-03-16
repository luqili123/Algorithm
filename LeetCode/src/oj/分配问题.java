package oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 对给定的n个任务与n个人之间的成本矩阵完成成本最低的任务分配策略。
 * 输入：第一行为用例个数，之后为每一个用例；用例的第一行为任务个数，即n；用例的第二行为使用逗号隔开的人员完成任务的成本；
	    每一个成本描述包括人员序号、任务序号和成本，使用空格隔开。人员序号和任务序号都是从1到n的整数，序号出现的次序没有固定规则。
1
4
2 1 6,1 2 2,1 3 7,1 4 8,1 1 9,2 2 4,2 3 3,2 4 7,3 1 5,3 2 8,3 3 1,3 4 8,4 1 7,4 2 6,4 3 9,4 4 4



2 1 3 4
 * @author lqllq
 *
 */
public class 分配问题 {
	
	static Integer[][] cost;
	static Integer[] result;
	static HashMap<Integer, Integer[]> hashMap=new HashMap<Integer, Integer[]>();
	static ArrayList<Integer> arrayList=new ArrayList<Integer>(); 
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int k=Integer.parseInt(scanner.nextLine());
		while(k-->0){
			int n=Integer.parseInt(scanner.nextLine());
			String[] task=scanner.nextLine().split(",");
			cost=new Integer[n][n];
			int row,col;
			for(int i=0;i<n*n;i++){
				String[] temp=task[i].split(" ");
				row=Integer.parseInt(temp[0])-1;
				col=Integer.parseInt(temp[1])-1;
				cost[row][col]=Integer.parseInt(temp[2]);				
			}
//			for (int i = 0; i < cost.length; i++) {
//				for (int j = 0; j < cost[i].length; j++) {
//					System.out.print(cost[i][j]+" ");
//				}
//				System.out.println();
//			}
			//------------------------------------------------------------
			int[] num=new int[n];
			for(int i=0;i<n;i++){
				num[i]=i;
			}
			perm(num, 0, num.length-1);
			Collections.sort(arrayList);
			for (Iterator iterator = arrayList.iterator(); iterator.hasNext();) {
				Integer integer = (Integer) iterator.next();
				System.out.println(integer);
			}
//			int temp=arrayList.get(0);
//			while(temp==arrayList.get(0)){
//				
//			}
			
		}
	}
	static int  min=Integer.MAX_VALUE;
	public static void perm(int[] num,int start,int end){
			
		if(start==end){				
			result=new Integer[num.length];
			int sum=0;
			for (int i = 0; i <=end; i++) {
				sum+=cost[i][num[i]];
			}
			for (int i = 0; i < result.length; i++) {
				result[i]=num[i]+1;
			}
			hashMap.put(sum, result);
			arrayList.add(sum);
//			System.out.println(sum +" "+Arrays.toString(num));
			
			
		}else {
			for (int i = start; i <=end; i++) {
				swap(num, start, i);
				perm(num, start+1, end);
				swap(num, start, i);
			}
			
		}
	}
	public static void swap(int[] list, int k, int i) {
		int temp = list[k];
		list[k] = list[i];
		list[i] = temp;
	}
}
