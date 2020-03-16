package list;

import java.util.Scanner;

public class window {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		
		for(int m=0;m<n;m++){
			scanner.nextLine();
			String[] temp=scanner.nextLine().split(" ");
			
			int len=temp.length;
			int[] array=new int[len];
			for(int i=0;i<len;i++){
				array[i]=Integer.parseInt(temp[i]);
			}
			
			int w=scanner.nextInt();
			int sum=0;
			for(int i=w-1;i<len;i++){
				int max=array[i];
				for(int j=i-w+1;j<=i;j++){
					if(array[j]>max)
						max=array[j];
				}
				sum+=max;
			}
			System.out.println(sum);
			
			
		}
	}
}
