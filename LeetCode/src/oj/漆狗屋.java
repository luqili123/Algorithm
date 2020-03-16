package oj;

import java.util.Scanner;

public class 漆狗屋 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=Integer.parseInt(scanner.nextLine());
		while(t-->0){
			int painter=scanner.nextInt();
			int num=scanner.nextInt();
			scanner.nextLine();
			String[] temp=scanner.nextLine().split(" ");
			int[] boards=new int[temp.length];
			for (int i = 0; i < temp.length; i++) {
				boards[i]=Integer.parseInt(temp[i]);
			}
			//-----------------------------------------------------------
			
		}
	}
}
