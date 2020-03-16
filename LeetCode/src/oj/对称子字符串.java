package oj;

import java.util.Scanner;

public class 对称子字符串 {
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
			for(int i=0;i<array.length;i++){
				for(int j=i+1;j<=array.length;j++){
					String str2=str.substring(i,j);
//					System.out.println(str2);
					int sum1=0,sum2=0;
					if(j-i>=2&&(j-i)%2==0){
						for(int k=0;k<(str2.length()/2);k++){
							sum1+=(int)(str2.charAt(k))-48;
						}
						for(int k=str2.length()/2;k<str2.length();k++){
							sum2+=(int)(str2.charAt(k))-48;
						}
						if(sum1==sum2&&str2.length()>max){
							max=str2.length();
						}
					}
					
				}
			}
			System.out.println(max);
			
		}
	}
}
