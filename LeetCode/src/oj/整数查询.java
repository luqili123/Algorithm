package oj;

import java.util.Scanner;

public class 整数查询 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=Integer.parseInt(scanner.nextLine());
		for(int p=0;p<n;p++){
			String[] lenStrings=scanner.nextLine().split(" ");
			int len1=Integer.parseInt(lenStrings[0]);
			int len2=Integer.parseInt(lenStrings[1]);
			String[] temp1=scanner.nextLine().split(" ");
			String[] temp2=scanner.nextLine().split(" ");
			int[] array1=new int[len1];
			int[] array2=new int[len2];
			for(int i=0;i<len1;i++){
				array1[i]=Integer.parseInt(temp1[i]);
			}
			for(int i=0;i<len2;i++){
				array2[i]=Integer.parseInt(temp2[i]);
			}
			//---------------------------------------
			int[] count=new int[len2];
			for(int i=0;i<len2;i++){
				count[i]=0;
				for(int j=0;j<len1;j++){
					if(array1[j]%array2[i]==0)
						count[i]++;
				}
			}
			for(int i=0;i<len2;i++){
				if(i==len2-1)
					System.out.println(count[i]);
				else {
					System.out.print(count[i]+" ");
				}
			}
			
		} 
	}
}
