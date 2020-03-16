package oj;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
/**
 * 
 * @author lqllq
 *
 */
public class 最长公共子序列_递归 {
	private static int  max=Integer.MIN_VALUE;
	private static ArrayList<String > arrayList=new ArrayList<String>();
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=Integer.parseInt(scanner.nextLine());
		for(int p=0;p<n;p++){
			String[] array1=scanner.nextLine().split(" ");
			String[] array2=scanner.nextLine().split(" ");
			int len1=array1.length;
			int len2=array2.length;
			
			//--------------------------------------------------------------------------------------------------------------
			
			LCS(array1, array2, len1-1, len2-1, "");
			
			Iterator<String> iterator=arrayList.iterator();
			while (iterator.hasNext()) {
				String string2 =  iterator.next();
				System.out.println(string2);
				
			}
			max=Integer.MIN_VALUE;
		}
	}
	public static void LCS(String[] array1,String[] array2,int m,int n,String sub){
		
		if(m==0||n==0){			
				return ;
		}else {
			if(array1[m].equals(array2[n])){
				 LCS(array1, array2, m-1, n-1, sub+array1[m]);
				 System.out.println(array1[m]);
			}else {				
				LCS(array1, array2, m-1, n, sub);
				
				LCS(array1, array2, m, n-1,  sub);
				
			}
		}
	}
}
