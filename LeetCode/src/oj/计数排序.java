package oj;

import java.util.Scanner;

public class 计数排序 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
			
		while(scanner.hasNext()){
			String[] temp=scanner.nextLine().split(" ");
			int[] array=new int[temp.length-1];
			for(int i=1;i<temp.length;i++){
				array[i-1]=Integer.parseInt(temp[i]);
			}
			//---------------------------------------------------------
			int max=Integer.MIN_VALUE;
			for(int i=0;i<array.length;i++){
				max=Math.max(array[i], max);
			}
			int[] bucket=new int[max+1];
			for(int i=0;i<array.length;i++){
				bucket[array[i]]++;
			}
			
			int j=0;
			for(int i=0;i<bucket.length;i++){
				while(bucket[i]-->0){
					array[j++]=i;
				}
			}
	//		System.out.println(Arrays.toString(array));
			for (int i = 0; i < array.length; i++) {
				if(i==array.length-1)
					System.out.println(array[i]);
				else {
					System.out.print(array[i]+" ");
				}
			}
			
			
		}
	}
}
