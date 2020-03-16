package array;

import java.util.Arrays;
import java.util.Scanner;

public class KthNumber {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=Integer.parseInt(scanner.nextLine());
		for(int i=0;i<t;i++){
			
			String[] temp1=scanner.nextLine().split(" ");
			int len=temp1.length;
			int[] array=new int[len];
			for(int x=0;x<len;x++){
				array[x]=Integer.parseInt(temp1[x]);
			}
			int left=scanner.nextInt();
			int right=scanner.nextInt();
			scanner.nextLine();
			int k=Integer.parseInt(scanner.nextLine());
			int[] range=new int[right-left+1];
			for(int n=left-1;n<right;n++){
				range[n-left+1]=array[n];
				
			}
			System.out.println(Arrays.toString(range));
			Arrays.sort(range);
			System.out.println(range[k-1]);	
			
		}
	}
}
