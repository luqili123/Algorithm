package 剑指offer;

import java.util.Arrays;

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
	https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/nge-tou-zi-de-dian-shu-dong-tai-gui-hua-ji-qi-yo-3/
 * @author lqllq
 * 思路：动态规划
 * 	使用动态规划解决问题一般分为三步：
	1.表示状态
	2.找出状态转移方程
	3.边界处理
	找出了最后一个阶段，那状态表示就简单了。
		首先用数组的第一维来表示阶段，也就是投掷完了几枚骰子。
		然后用第二维来表示投掷完这些骰子后，可能出现的点数。
		数组的值就表示，该阶段各个点数出现的次数。
		所以状态表示就是这样的：dp[i][j]dp[i][j] ，表示投掷完 ii 枚骰子后，点数 jj 的出现次数。

		单单看第 nn 枚骰子，它的点数可能为 1 , 2, 3, ... , 61,2,3,...,6 ，因此投掷完 nn 枚骰子后点数 jj 出现的次数，
		可以由投掷完 n-1n−1 枚骰子后，对应点数 j-1, j-2, j-3, ... , j-6j−1,j−2,j−3,...,j−6 出现的次数之和转化过来。
		
		for (第n枚骰子的点数 i = 1; i <= 6; i ++) {
    		dp[n][j] += dp[n-1][j - i]
}
 */
public class n个骰子的点数 {
	/**
	 * 动态规划，二维数组,dp[i][j]表示，投掷i个骰子，点数j出现的次数
	 * @param n
	 * @return
	 */
	public static double[] twoSum(int n) {
		if(n<1){
			return new double[]{};
		}
		//定义dp数组，n个骰子最大点数为6*n
		int[][] dp=new int[n+1][6*n+1];
		//初始化,只有一个骰子时，所有点数出现次数都为1
		for(int i=1;i<=6;i++){
			dp[1][i]=1;
		}
		//依次投掷骰子
		for(int i=2;i<dp.length;i++){
			//投掷第i个骰子时，j的取值范围为i到6*i
			for(int j=i;j<=6*i;j++){
				for(int k=1;k<=6;k++){
					//投掷i-1个骰子的最小点数就是i-1，再小就不会出现了
					if(j-k<i-1){
						break;
					}
					dp[i][j]+=dp[i-1][j-k];
				}
			}
		}
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[i].length;j++){
				System.out.print(dp[i][j]);
			}
			System.out.println();
		}
		
		
		
		
		double total=Math.pow(6, n);
		//这里由于n个骰子
		double[] res=new double[5*n+1];
		for(int i=n;i<=6*n;i++){
			res[i-n]=dp[n][i]/total;
		}
		Arrays.sort(res);
		return res;
		
    }
	public static void main(String[] args){
		twoSum(2);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
