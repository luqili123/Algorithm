package oj;

import java.util.Scanner;

public class 按照数值个数排序 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		while(t-->0){
			int len=scanner.nextInt();
			int[] array=new int[len];
			int max=Integer.MIN_VALUE;//记录数组中的最大值
			for(int i=0;i<len;i++){
				array[i]=scanner.nextInt();
				max=Math.max(array[i], max);
			}
			//--------------------------------------
			//计数排序的方法
			int[] bucket=new int[max+1];
			int[] index=new int[max+1];
			for(int i=0;i<array.length;i++){
				bucket[array[i]]++;
				
			}
			for(int i=0;i<index.length;i++){
				index[i]=i;
			}
			for(int i=0;i<bucket.length;i++){
				for(int j=0;j<bucket.length-1;j++){
					if(bucket[j]<bucket[j+1]){
						swap(bucket, j, j+1);
						swap(index, j, j+1);
					}
				}

			}
			int x=0;
			int count=0;
			for(int i=0;i<bucket.length&&count<array.length;i++){
				for(int j=0;j<bucket[i]&&bucket[i]>0;j++){
					if(count==array.length-1){
						System.out.println(index[i]);								
					}else {
						System.out.print(index[i]+" ");					
					}
					count++;
				}
			}
		}
	}
	public static void swap(int[] array,int i,int j){
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
}	
