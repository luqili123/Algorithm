package oj;

import java.util.Scanner;

public class 字符串匹配问题 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=Integer.parseInt(scanner.nextLine());
		for(int p=0;p<n;p++){
			String str=scanner.nextLine();
			int index=str.indexOf(',');
			String pattern=str.substring(index+1);
//			System.out.println(pattern);
			String result="";
			for(int i=0;i<index;i++){
				if(pattern.equals(str.substring(i, i+pattern.length()))){
					result+=i+" ";
				}				
			}
			
			System.out.println(result.trim());
		}
	}

}
