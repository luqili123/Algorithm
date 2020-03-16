package oj;

import java.util.Arrays;
import java.util.Scanner;

public class 按照另一个数组排序 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		while(t-->0){
			int len1=scanner.nextInt();
			int len2=scanner.nextInt();
			int[] arr1=new int[len1];
			int[] arr2=new int[len2];
			for(int i=0;i<len1;i++){
				arr1[i]=scanner.nextInt();
			}
			for(int i=0;i<len2;i++){
				arr2[i]=scanner.nextInt();
			}
		
			//------------------------------------------------------------
			int p=0;
			for(int i=0;i<len2;i++){
				for(int j=0;j<len1;j++){
					if(arr1[j]==arr2[i]){
						swap(arr1, p++, j);
					}
				}
			}
//			System.out.println();
//			int[] arr=Arrays.copyOfRange(arr1, p, arr1.length);
			Arrays.sort(arr1, p, arr1.length);
			for(int i=0;i<arr1.length;i++){
				if(i==arr1.length-1)
					System.out.println(arr1[i]);
				else {
					System.out.print(arr1[i]+" ");
				}
					
			}
		}
	}
	public static void swap(int[] arr,int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
