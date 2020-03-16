package 剑指offer;
/**
 * 
	在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
	你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
	给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
	
输入: 
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 12
解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * @author lqllq
 *	思路：动态规划：设dp[i][j]表示（i，j）位置的最大价值，一般情况，(i,j)位置的最大价值等于左边和上边较大的那一个加上自己的价值，
 *	即dp[i][j[=Max(dp[i-1][j],dp[i][j-1])+v(i,j)),然后在考虑一些边界情况
 */
public class 礼物最大价值 {
	public int maxValue(int[][] grid) {
		if(grid==null){
			return 0;
		}
		//多一个可以减少边界条件的判断
		int[][] dp=new int[grid.length+1][grid[0].length+1];
		
		for(int i=1;i<dp.length;i++){
			for(int j=1;j<dp[i].length;j++){
				dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];//不要忘了i-1，j-1
			}
		}
		return dp[grid.length][grid[0].length];
    }
	public static void main(String[] args){
		礼物最大价值 t=new 礼物最大价值();
		int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(t.maxValue(grid));
	}
}
