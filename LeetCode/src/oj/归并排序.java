package oj;

import java.util.Scanner;

public class 归并排序 {
	public static void main (String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNextLine()){

			String[] str=scanner.nextLine().split(" ");
			int[] array=new int[str.length-1];
			for(int i=0;i<array.length;i++){
				array[i]=Integer.parseInt(str[i+1]);
			}
			//------------------------------------------------
			
			mergeSort(array, 0, array.length-1);
			
			for (int i = 0; i < array.length; i++) {
				if(i==array.length-1)
					System.out.println(array[i]);
				else {
					System.out.print(array[i]+" ");
				}
			}
			
		}
	}
	
	public static void mergeSort(int[] array,int l,int r){
		if(l==r){
			return ;
		}else {
			int mid=(l+r)/2;
			mergeSort(array, l, mid);
			mergeSort(array, mid+1, r);
			merge(array, l,mid, r);			
		}		
	}
	public static void merge(int[] array,int l,int m,int r){
		int[] help=new int[r-l+1];
		int p1=l;
		int p2=m+1;
		int i=0;
		while(p1<=m&&p2<=r){
			help[i++]=array[p1]<array[p2]?array[p1++]:array[p2++];
		}
		while(p1<=m){
			help[i++]=array[p1++];
		}
		while(p2<=r){
			help[i++]=array[p2++];
		}
		for(int k=0;k<help.length;k++){
			array[l+k]=help[k];
		}
	}
}
