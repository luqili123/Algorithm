package leetcodeTop精选面试题;
/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * @author lqllq
 * 思路：回文子串就是正反相同，我们可以将字符串导致，然后求两个字符串的最长公共子串
 * 求最长公共子串，使用动态规划
 * 
 * 但对于这个例子“abc435cba”，这个子串并不是回文子串，但用上面的方法判断的是回文字符串，s所以单纯的求公共子串并不是完全正确。
 * 应该
 */
public class 最长回文子串 {
	 public static String longestPalindrome(String s) {
		 if(s.length()==0){
			 return "";
		 }
		 String s2=new StringBuffer(s).reverse().toString();
		 //这个记录的是公共子串的长度
		 int[][] dp=new int[s.length()+1][s2.length()+1];
		 //记录最大长度
		 int maxLen=0;
		 //记录达到最大长度时公共子串最后一个字符的位置
		 int maxEnd=0;
		 for(int i=1;i<dp.length;i++){
			 for(int j=1;j<dp[i].length;j++){
				 if(s.charAt(i-1)==s2.charAt(j-1)){
					
					 dp[i][j]=dp[i-1][j-1]+1;
//					 System.out.println("s:"+s.charAt(i-1)+" "+"s2:"+s2.charAt(j-1)+" dp="+dp[i][j]);
				 }else{
					 dp[i][j]=0;
				 }
				 if(dp[i][j]>maxLen){
					 //当前j位置对于原字符串的位置
					 int originIndex=s2.length()-(j-1)-1;
					 //判断对应位置是否为i
					 if(originIndex+dp[i][j]-1==i-1){
						 maxLen=dp[i][j];
						 maxEnd=i-1;
//						 System.out.println(maxLen+" "+maxEnd+" "+s.substring(maxEnd-maxLen+1,maxEnd+1));
					 }
//					
				 }
			 }
		 }
//		 for(int i=0;i<dp.length;i++){
//			 for(int j=0;j<dp[0].length;j++){
//				 System.out.print(dp[i][j]+" ");
//			 }
//			 System.out.println();
//		 }
		 return s.substring(maxEnd-maxLen+1,maxEnd+1);
	 }
	 public static void main(String[] args){
		 System.out.println(longestPalindrome("babad"));
	 }
}
