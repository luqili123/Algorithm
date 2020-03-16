package oj;

import java.util.Scanner;
import java.util.Stack;

/**
4
3 1 2 1
4 1 2 2 1
3 3 5 3
6 a b c d c a

 * @author lqllq
 *
 */

public class 链表回文 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=Integer.parseInt(scanner.nextLine());
//		System.out.println("HH"+n);
		for(int p=0;p<n;p++){
			String[] array=scanner.nextLine().split(" ");
			int k=Integer.parseInt(array[0]);			
			Stack<String> stack=new Stack<String>();
			for(int i=1;i<array.length;i++){
				stack.push(array[i]);
			}
			boolean flag=true;
			for(int i=1;i<array.length;i++){
				 
				if(!stack.pop().equals(array[i])){
					
					flag=false;
				}
			}
			System.out.println(flag);
			
		}
	}
}
