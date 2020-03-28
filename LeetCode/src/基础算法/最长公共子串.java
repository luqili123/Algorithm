package 基础算法;
/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子串。子串是连续的。
 * @author lqllq
 * dp[i][j]代表s1以i位置元素结尾，s2以j位置元素结尾的最长公共子串
 * 递推公式：
 *  i=0或j=0 dp[i][j]=0
 *  s1[i]==s2[j] dp[i][j]=dp[i-1][j-1]+1，相等，那么就看去掉这两个字符之后的字符串的最长子串长度
 *  s1[i]!=s2[j] dp[i][j]=0,如果不等就另起炉灶
 */
public class 最长公共子串 {
	 public int longestCommonSubsequence(String text1, String text2) {
		 if(text1.length()==0||text2.length()==0){
			 return 0;
		 }
		 int[][] dp=new int[text1.length()+1][text2.length()+1];
		 for(int i=1;i<dp.length;i++){
			 for(int j=1;j<dp[0].length;j++){
				 //如果两个字符串的最后一个字符相同，则公共子序列长度等于去掉最后一个字符的两个字符串的公共子序列长度加1
				 if(text1.charAt(i-1)==text2.charAt(j-1)){
					 dp[i][j]=dp[i-1][j-1]+1;
				 }else{
					 dp[i][j]=0;				 
				 }
			 }
		 }
		 return dp[text1.length()][text2.length()];
	 }
}
