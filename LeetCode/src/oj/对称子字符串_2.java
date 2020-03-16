package oj;

import java.util.Scanner;

public class 对称子字符串_2 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=Integer.parseInt(scanner.nextLine());
		for(int p=0;p<n;p++){
			String str=scanner.nextLine();
			char[] temp=str.toCharArray();
			int[] array=new int[temp.length];
			for(int i=0;i<temp.length;i++){
				array[i]=(int)(temp[i])-48;				
			}
			//--------------------------------------------
			int max=Integer.MIN_VALUE;
			for(int i=0;i<array.length-1;i++){
				int x=i;
				int y=i+1;
				int count=0;
				int left=0;
				int right=0;
				while(x>=0&&y<array.length&&x<y){
					left+=array[x];
					right+=array[y];
					if(left==right){
						count=y-x+1;
					}
					x--;
					y++;
				}
				if(max<count){
					max=count;
				}
				
			}
			System.out.println(max);
		}
	}
}
