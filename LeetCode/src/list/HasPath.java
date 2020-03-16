package list;

public class HasPath {
	//可以往上下左右四个方向寻路
	private final static int[][] next={{0,-1},{0,1},{-1,0},{1,0}};
	//矩阵的行与列数
	private int rows;
	private int cols;
	
	 public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
	{
	    //合法性检查
		 if(rows==0||cols==0)
			 return false;
		 this.rows=rows;
		 this.cols=cols;
		 //标记矩阵，标记每个位置是否被访问，如果被访问则为true,默认为false
		 boolean[][] marked=new boolean[rows][cols];
		 //获取矩阵
		 char[][] matrix2=buildMatrix(matrix);
		 //一次穷举每个元素，若找到路径则返回true，若未找到则往回回溯，若遍历完仍然未找到，则返回false
		 for(int i=0;i<rows;i++){
			 for(int j=0;j<cols;j++){
				 if(backtracking(matrix2, str, marked, 0, i, j))
					 return true;
			 }
		 }
		 return false;
	}
	 //寻找路径
	 private boolean backtracking(char[][] matrix,char[] str,
			 boolean[][] marked,int pathLen,int r,int c) {
		//若路径长度等于字符串长度，说明查找成功
		 if(pathLen==str.length)
			 return true;
		 //合法性判断
		 if(r<0||r>=rows||c<0||c>=cols||matrix[r][c]!=str[pathLen]||marked[r][c]){
			 return false;
		 }
		 //结果上面的判断，说明matrix[r][c]位置的字符与str[pathLen]位置字符相同，此时继续往下寻找，
		 //方向为上下左右，next[][]数组分别对应四个方向上，坐标的变化
		 marked[r][c]=true;
		 for(int[] n:next){
			 	if(backtracking(matrix, str, marked, pathLen+1, r+n[0], c+n[1]))
			 		return true;
		 }
		 //如果运行到这步，说明从该点往下走无法找到正确路径，此时应该回溯，将该点重新标记为未访问
		 marked[r][c]=false;
		 return false;
	}
	 //题目中只给了一个数组，需要将数组转换成矩阵
	 private char[][] buildMatrix(char[] matrix) {
		char[][] matrix2=new char[rows][cols];
		int index=0;
		for(int r=0;r<rows;r++){
			for (int c = 0; c < cols; c++) {
				matrix2[r][c]=matrix[index++];			
			}
		}
		return matrix2;
	}
}
