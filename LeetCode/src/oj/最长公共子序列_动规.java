package oj;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
/**
1
ABCB
BDCA
 * @author lqllq
 *
 */
public class 最长公共子序列_动规 {
	
	private static Set<String> set=new HashSet<String>();
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=Integer.parseInt(scanner.nextLine());
		for(int p=0;p<n;p++){
			char[] array1=scanner.nextLine().toCharArray();
			char[] array2=scanner.nextLine().toCharArray();
			int len1=array1.length;
			int len2=array2.length;
			//---------------------------------------------------------------------------
			int[][] dp=getDP(array1, array2);	
			String res=new String("");
			
			LCS(dp, res, array1, array2,len2, len1);
			//最长子序列集合
			String[] result=new String[set.size()];
			int i=0;
			for (Iterator iterator = set.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
//				System.out.println(string);
				result[i]=string;
				i++;
			}
			
			for(i=0;i<result.length;i++){
				for(int j=0;j<result.length-1;j++){
					if(result[j].compareTo(result[j+1])>0)
						swap(result, j, j+1);
				}
			}
			for (int j = 0; j < result.length; j++) {
				System.out.println(result[j]);
			}

			set.clear();
		}
	}
	
	public  static  int[][] getDP(char[] arr1,char[] arr2){
		//计数矩阵dp[i][j]的值代表arr1[0-i],arr2[0-j]长度下的最长公共子序列的长度
		int [][] dp=new int[arr2.length+1][arr1.length+1];
		//为矩阵赋值		
		dp[1][1]=(arr1[0]==arr2[0]) ? 1 : 0;
		for(int i=1;i<=arr2.length;i++){
			for(int j=1;j<=arr1.length;j++){
				dp[i][j]=(arr2[i-1]==arr1[j-1]) ? (dp[i-1][j-1]+1) : Math.max(dp[i-1][j], dp[i][j-1]); 
			}
		}
		return dp;
	}
	
	public static void LCS(int[][] dp,String res,char[] arr1,char[] arr2,int m,int n){
		if(m==0||n==0){
			set.add(res);
		}else {
			if(dp[m][n]>dp[m-1][n]&&dp[m][n]>dp[m][n-1]){
				LCS(dp, arr2[m-1]+res, arr1, arr2, m-1, n-1);
			}else if (dp[m][n]==dp[m-1][n]&&dp[m][n]==dp[m][n-1]) {
				LCS(dp, res, arr1, arr2, m-1, n);
				LCS(dp, res, arr1, arr2, m, n-1);
			}else if (dp[m][n]==dp[m-1][n]&&dp[m][n]>dp[m][n-1]) {
				LCS(dp, res, arr1, arr2, m-1, n);
			}else if (dp[m][n]>dp[m-1][n]&&dp[m][n]==dp[m][n-1]) {
				LCS(dp, res, arr1, arr2, m, n-1);
			}
		}
	}
	
	public static void swap(String[] result,int i,int j){
		String temp=result[i];
		result[i]=result[j];
		result[j]=temp;
	}
}
