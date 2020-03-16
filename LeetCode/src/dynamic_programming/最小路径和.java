package dynamic_programming;

public class 最小路径和 {
	
	//找出所有路径的和
	public static void printPathSum(int[][] grid,int i,int j,int sum){
		if(i==grid.length-1&&j==grid[i].length-1){
			System.out.println(sum+grid[i][j]);
			return;
		}else if (i==grid.length-1) {
			printPathSum(grid, i, j+1, sum+grid[i][j]);
		}else if (j==grid[i].length-1) {
			printPathSum(grid, i+1, j, sum+grid[i][j]);
		}else {
			printPathSum(grid, i, j+1, sum+grid[i][j]);
			printPathSum(grid, i+1, j, sum+grid[i][j]);
		}
		
	}
	//找出路径的最小和
	public static int printMinPathSum(int[][] grid,int i,int j){
		if(i==grid.length-1&&j==grid[i].length-1){
			return grid[i][j];
		}else if (i==grid.length-1) {
			return grid[i][j]+printMinPathSum(grid, i, j+1);
		}else if (j==grid[i].length-1) {
			return grid[i][j]+printMinPathSum(grid, i+1, j);
		}else {
			return grid[i][j]+Math.min(printMinPathSum(grid, i, j+1),printMinPathSum(grid, i+1, j));
		}
	}
	
	//递归存在很多重复计算，使用动态规划，记录路径，减少重复计算，dp[i][j]代表从当前位置到右下角的最短路径
	public static int minPathSum(int[][] grid) {
		int x=grid.length;
		int y=grid[0].length;
		int[][] dp=new int[x][y];	
		for(int i=x-1;i>=0;i--){
			for(int j=y-1;j>=0;j--){
				if(i==grid.length-1&&j==grid[i].length-1){
					dp[i][j]=grid[i][j];
				}else if (i==grid.length-1) {
					dp[i][j]=grid[i][j]+dp[i][j+1];
				}else if (j==grid[i].length-1) {
					dp[i][j]=grid[i][j]+dp[i+1][j];
				}else {
					dp[i][j]=grid[i][j]+Math.min(dp[i+1][j], dp[i][j+1]);
				}
			}
		}
		return dp[0][0];
        
    }
	//递归存在很多重复计算，使用动态规划，记录路径，减少重复计算,dp[i][j]代表走到当前位置的最短路径
	public static  int minPathSum2(int[][] grid) {
		int[][] dp=new int[grid.length][grid[0].length];
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[i].length;j++){
				if(i==0&&j==0){
					dp[i][j]=grid[i][j];
				}else if (i==0) {
					dp[i][j]=grid[i][j]+dp[i][j-1];
				}else if (j==0) {
					dp[i][j]=grid[i][j]+dp[i-1][j];
				}else {
					dp[i][j]=grid[i][j]+Math.min(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[grid.length-1][grid[0].length-1];
        
    }
	public static void main(String[] args) {
		int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
//		printPathSum(grid, 0, 0, 0);
//		System.out.println(printMinPathSum(grid, 0, 0));
		System.out.println(minPathSum2(grid));
	}
}
