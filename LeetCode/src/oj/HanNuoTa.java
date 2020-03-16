package oj;

import java.util.Scanner;


public class HanNuoTa {
	private int count=0;
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		for(int i=0;i<t;i++){
			int n=scanner.nextInt();
			HanNuoTa h=new HanNuoTa();
			System.out.println(h.hanNuoTa(n,"left","mid","right","left","right"));
		}
		 
	}
	private int hanNuoTa(int n,String left,String mid,String right,String from,String to ) {
		if(n==1){
			if(from==mid||to==mid)
				return 1;
			else {
				return 2;
			}
		}else {
			int num1=hanNuoTa(n-1, left, mid, right, left, right);
			int num2=hanNuoTa(1, left, mid, right, left, mid);
			int num3=hanNuoTa(n-1, left, mid, right, to, from);
			int num4=hanNuoTa(1, left, mid, right, mid, right);		
			int num5=hanNuoTa(n-1, left, mid, right, left, right);
			return num1+num2+num3+num5+num4;
		}
	}
}
