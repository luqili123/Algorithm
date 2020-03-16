package oj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 给定一组n个工作，其中每个工作i都有一个截止日期和与之相关的利润。每个作业需要1个单位的时间才能完成，一次只能安排一个作业。
 * 当且仅当工作在截止日期前完成时，我们才能赚取利润。任务是找到最大利润和完成的工作数量
 * 
 *贪心策略：
 *	先做最先完成的任务，可以获得最大利润
 * @author lqllq
 *
 */
public class 时间与收益 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while (t-- > 0) {
			int task = scanner.nextInt();
			int[] id = new int[task];
			int[] date = new int[task];
			int[] profit = new int[task];
			int deadLine = -1;
			for (int i = 0; i < task; i++) {
				id[i] = scanner.nextInt();
				date[i] = scanner.nextInt();
				if (date[i] > deadLine) {
					deadLine = date[i];
				}
				profit[i] = scanner.nextInt();
			}
			// -------------------------------------
			int[] result = new int[deadLine];
			// 先对价值从大到小排序，id数组跟着一起变
			for (int i = 0; i < profit.length; i++) {
				for (int j = 0; j < profit.length - 1; j++) {
					if (profit[j] < profit[j + 1]) {
						swap(profit, j, j + 1);
						swap(date, j, j + 1);
					}
				}
			}
			//取出最大利润，按照截止日期放入result数组中，如果该位置有元素，则往前找，直到找不到
			
			for(int i=0;i<profit.length;i++){
				if(result[date[i]-1]==0){
					result[date[i]-1]=profit[i];
				}else {
					for(int j=date[i]-1;j>=0;j--){
						if(result[j]==0){
							result[j]=profit[i];
						}
					}
				}
			}
			int sum=0;
			int count=0;
			for(int i=0;i<result.length;i++){
				if(result[i]!=0){
					count++;
					sum+=result[i];
				}
				
				
			}
			System.out.println(count+" "+sum);

		}
	}
	public static void swap(int[] array,int i,int j){
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
}
