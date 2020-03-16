package oj;

import java.util.Scanner;

import sun.tools.jar.resources.jar;

public class 冒泡排序 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String[] temp=scanner.nextLine().split(" ");
		int[] array=new int[temp.length-1];
		for(int i=1;i<temp.length;i++){
			array[i-1]=Integer.parseInt(temp[i]);
		}
		//_-------------------------------------------------------
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length-1;j++){
				if(array[j]<array[j+1])
					continue;
				else {
					int t=array[j];
					array[j]=array[j+1];
					array[j+1]=t;
				}
			}
		}
		for(int i=0;i<array.length;i++){
			if(i==array.length-1)
				System.out.println(array[i]);
			else {
				System.out.print(array[i]+" ");
			}
		}
	}
	public static void swap(int a,int b){
		int temp1=a;
		a=b;
		b=temp1;
	}
}
