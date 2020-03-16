package oj;

import java.util.Scanner;
import java.util.Stack;

public class 链表区间逆序 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=Integer.parseInt(scanner.nextLine());

		for(int p=0;p<n;p++){
			String[] temp=scanner.nextLine().split(" ");
			int len=Integer.parseInt(temp[0]);	
			int k=Integer.parseInt(temp[temp.length-1]);
			int time=len/k;
			String[] array=new String[len];
			for(int i=1;i<temp.length-1;i++){
				array[i-1]=temp[i];
			}		
			Stack<String> stack=new Stack<String>();
			for(int i=0;i<time;i++){
				for(int j=i*k;j<(i+1)*k;j++){
					stack.push(array[j]);
				}
				for(int j=i*k;j<(i+1)*k;j++){
					array[j]=stack.pop();
				}
			}
			for(int i=0;i<array.length;i++){
				if(i==array.length-1)
					System.out.print(array[i]);
				else {
					System.out.print(array[i]+" ");
				}
				
			}
			System.out.println();
		}
	}
}
