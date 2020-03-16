package oj;

import java.util.Scanner;

/**
 * 小张想要通过明天的考试。他知道考题的分值分布，也知道考试中要拿到每一个题目需要耗费的时间。
 * 假设考试时长为h，共n个题目，需要拿到p分才能通过考试。现在已知每个考题的得分与耗时，请你判
 * 断小张能否通过合理安排时间，而通过考试，并给出通过考试的最短时间。
 * 
 *首先是0-1背包问题相同的解法，
 *
 *
 *	如何满足需要拿到p分才能通过考试?
	若数组中最后一行一列的数大于p,证明可以拿到p分,此时
	
	回溯找,即更新完dp数组后再找大于p分的最小时间.
	在遍历过程中记录,若大于p分时,更新当前的时间值(也就是t),	
 *
 *
 * @author lqllq
 *
 */
public class 能否通过考试 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int x=scanner.nextInt();
		while(x-->0){
			int n=scanner.nextInt();
			int time=scanner.nextInt();
			int minScore=scanner.nextInt();
			int[] t=new int[n+1];
			int[] s=new int[n+1];
			
			for(int i=1;i<=n;i++){
				t[i]=scanner.nextInt();
				s[i]=scanner.nextInt();
				
			}
			//----------------------------------------
			int[][] dp=new int[n+1][time+1];
			
			//可以不写
			for(int i=0;i<dp.length;i++){
				dp[i][0]=0;
			}
			for(int i=0;i<dp[0].length;i++){
				dp[0][i]=0;
			}
			//
//			for (int i = 0; i < dp.length; i++) {
//				for (int j = 0; j < dp[i].length; j++) {
//					System.out.print(dp[i][j]+" ");
//				}
//				System.out.println();
//			}
			
			//根据公式填表
			int min=Integer.MAX_VALUE;
			for(int i=1;i<dp.length;i++){//不处理第一行
				for(int j=1;j<dp[i].length;j++){//不处理第一列
					//公式：
					if(t[i]>j){
						dp[i][j]=dp[i-1][j];
					}else if (t[i]<=j) {
						dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-t[i]]+s[i]);
					}
					if(dp[i][j]>=minScore){
						min=Math.min(j, min);
					}
				}
			}
			
			for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
			if(dp[n][time]>=minScore){
				System.out.println("YES "+min);
			}else {
				System.err.println("NO");
			}
			
		}
	}
}
