package leetcodeTop精选面试题;
/**\
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 示例:
	输入: 
	
	1 0 1 0 0
	1 0 1 1 1
	1 1 1 1 1
	1 0 0 1 0
	
	输出: 4
 * @author lqllq
 * dp[i][j] 代表以i，j位置为右下角的正方形的边长是多少
 * ，如果matrix[i][j]位置为0，那么dp[i][j]只能是0，若是1，则dp[i][j]的值应该由它的左上，上方，左方的值中最小的值决定
 * 状态转移方程：
 * matrix[i][j]=0 ,dp[i][j]=0;
 * matrix[i][j]=1, dp[i][j]=min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1;
 */
public class 矩阵中的最大正方形 {
	public static int maximalSquare(char[][] matrix) {
		if(matrix==null||matrix.length==0){
			return 0;
		}
		
		int x=matrix.length;
		int y=matrix[0].length;
		int max=0;
		int[][] dp=new int[x+1][y+1];
		for(int i=1;i<=x;i++){
			for(int j=1;j<=y;j++){
				if(matrix[i-1][j-1]-48==0){
					dp[i][j]=0;
				}else if(matrix[i-1][j-1]-48==1){
					dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
				}
				
				if(dp[i][j]>max){
					max=dp[i][j];
				}
			}
			
		}
		return max*max;
    }
	public static void main(String[] args){
		char[][] matrix={{'0','1'}};
		System.out.print(maximalSquare(matrix));
		
	}

}
