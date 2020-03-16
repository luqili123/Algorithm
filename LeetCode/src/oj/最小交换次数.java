package oj;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Given an array of N distinct elementsA[ ], find the minimum number of swaps required to sort the array.
 * Your are required to complete the function which returns an integer denoting the minimum number of swaps, required to sort the array.
 * 
 * 
 * 解法：
 * 1.先对数组排序
 * 2.遍历排序后的数组，如果当前遍历的元素原来不在这位置，那么，就把这元素和原来他在的那个位置上的元素交换，如果遍历前后元素位置没变，则跳过
 * @author lqllq
 *
 */
public class 最小交换次数 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		while(t-->0){
			int len=scanner.nextInt();
			int[] array=new int[len];
			int[] sorted=new int[len];
			for(int i=0;i<len;i++){
				array[i]=scanner.nextInt();
				sorted[i]=array[i];
			}
			//----------------------------------------------
			int count=0;
			Arrays.sort(sorted);
			for(int i=0;i<len;i++){
				if(array[i]!=sorted[i]){
					int index=-1;
					for(int j=0;j<len;j++){
						if(sorted[i]==array[j]){
							index=j;
							break;
						}
					}
					swap(array, i, index);
					count++;
				}
			}
			System.out.println(count);
		}
	}
	public static  void swap(int[] array,int i,int j) {
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
}
