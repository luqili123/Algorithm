package oj;

import java.util.Scanner;

public class 序号乘方 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=Integer.parseInt(scanner.nextLine());
		while(t-->0){
			long power=Long.parseLong(scanner.nextLine());
			long count=0;
			long sum=0;
			while(power>=sum){
				count++;
				sum=count*(count+1)*(count*2+1)/6;				
				
			}
			System.out.println(count-1);
		}
	}
}
