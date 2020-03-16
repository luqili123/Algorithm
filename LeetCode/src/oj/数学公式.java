package oj;

import java.util.Scanner;

/**
 * Implement pow(A, B) % C.In other words, given A, B and C, find (A^B)%C
 * @author lqllq
 *
 */
public class 数学公式 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=Integer.parseInt(scanner.nextLine());
		for(int p=0;p<n;p++){
			long sum=1;
			String[] temp=scanner.nextLine().split(" ");
			Long a=Long.parseLong(temp[0]);
			Long b=Long.parseLong(temp[1]);
			Long c=Long.parseLong(temp[2]);
			for(int i=0;i<b;i++){
				sum=sum*a%c;
			}
			System.out.println(sum);
		}
	}
}
