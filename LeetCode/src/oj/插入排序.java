package oj;

import java.util.Scanner; 

public class 插入排序 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int k=Integer.parseInt(scanner.nextLine());
		for(int p=0;p<k;p++){
			String[] temp=scanner.nextLine().split(" ");
			int[] array=new int[temp.length-1];
			for(int i=1;i<temp.length;i++){
				array[i-1]=Integer.parseInt(temp[i]);
			}
			//----------------------------------------------------
			int len=array.length;
		
			for(int i=1;i<len;i++){
				int value=array[i];
				int j=i-1;
				while(j>=0&&array[j]>value){
					array[j+1]=array[j];
					j--;
				}
				array[j+1]=value;
			}
			
			for(int i=0;i<len;i++){
				if(i==len-1)
					System.out.println(array[i]);
				else {
					System.out.print(array[i]+" ");
				}
			}
			
		}
	}
	
}
