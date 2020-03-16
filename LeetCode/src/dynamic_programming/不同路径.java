package dynamic_programming;

public class 不同路径 {
	 public static int uniquePaths(int m, int n) {
		 return pathNum(0, 0, m, n);
	 }
	 public static int pathNum(int i,int j,int m,int n){
		 if(i==m-1&&j==n-1){
			 return 1;
		 }else if (i==m-1) {
			return pathNum(i, j+1, m, n);
		}else if (j==n-1) {
			return pathNum(i+1, j, m, n);
		}else{
			return pathNum(i, j+1, m, n)+pathNum(i+1, j, m, n);
		}
	 }
	 public static int uniquePaths2(int m,int n){
		 int[][] dp=new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(i==0&&j==0){
					dp[i][j]=1;
				}else if (i==0) {
					dp[i][j]=dp[i][j-1];
				}else if (j==0) {
					dp[i][j]=dp[i-1][j];
				}else {
					dp[i][j]=dp[i][j-1]+dp[i-1][j];
				}
			}
		}
		return dp[m-1][n-1];
	 }

	 public static void main(String[] args) {
		System.out.println(uniquePaths2(7, 3));
	}
}
