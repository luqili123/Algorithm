package math;

import java.util.Scanner;

public class Addition {
	public static void main(String[] args) {
		Scanner  scan=new Scanner(System.in);
		int n=scan.nextInt();
		for(int i=0;i<n;i++){
			System.out.println(scan.nextInt()+scan.nextInt());
		}
			
	}
}
