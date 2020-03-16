package 剑指offer;
/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法
输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * @author lqllq
 * 思路： 动态规划：由题目可以了解到，最多有同时翻译两位数，且这个两位数得小于等于25，这就和青蛙跳台阶是一个思想，从头开始跳，你可以选择一次跳一个台阶，也可以两个。
 * 				  这个题目多了一个约束条件，一次跳两个的时候得小于等于25
 * 	
 * 		递归：进行翻译是，最多只有两种选择，就像是走一颗二叉树的不同路径，可以用递归遍历二叉树
 */
public class 把数字翻译成字符串 {
	/**
	 * 动态规划
	 * @param num
	 * @return
	 */
	public int translateNum(int num) {
		String str=String.valueOf(num);
		int[] dp=new int[str.length()+1];
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<=str.length();i++){
			//前两位的值小于25,且两位数不能是0开头
			if(str.charAt(i-2)=='1'||(str.charAt(i-2)=='2'&&str.charAt(i-1)<'6')){
				dp[i]=dp[i-1]+dp[i-2];
			}else{
				dp[i]=dp[i-1];
			}
		}
		return dp[str.length()];
    }
	
	/**
	 * 递归
	 * @param num
	 * @return
	 */
	public int translateNum2(int num) {
		String str=String.valueOf(num);
		return travle(str,0);
	}
	
	public int travle(String str,int index){

		if(index>=str.length()-1){
			return 1;
		}
		//若当前位置为为0或者大于25，都不能选两个
		if(str.charAt(index)=='0'||(str.charAt(index)=='2'&&str.charAt(index+1)>'5')||str.charAt(index)>'2'){
			return travle(str,index+1);
		}else{		
			return travle(str,index+1)+travle(str,index+2);
		}
	}
	
	
	
	
	public static void main(String[] args){
		把数字翻译成字符串 t=new 把数字翻译成字符串();
		System.out.println(t.translateNum(624));
		System.out.println(t.translateNum2(624));
		
		
	}
}
