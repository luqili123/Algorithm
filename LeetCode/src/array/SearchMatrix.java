package array;

public class SearchMatrix {
	//每行的元素从左到右升序排列。
	//每列的元素从上到下升序排列。
	//左下角和右上角的数。左下角往上所有的数变小，往右所有数增加，那么我们就可以和目标数相比较，
	//如果目标数大，就往右搜，如果目标数小，就往上搜。这样就可以判断目标数是否存在。当然我们也可以把起始数放在右上角，往左和下搜，停止条件设置正确就行。
	  public boolean searchMatrix(int[][] matrix, int target) {
		 int i=matrix.length-1,j=0;
		if(matrix.length==0||matrix[0].length==0) return false;
		if(target<matrix[0][0]||target>matrix[matrix.length-1][matrix[0].length-1])
			return false;
		while(i>=0&&j<matrix[0].length){
			if(target==matrix[i][j]) return true;
			else if (target>matrix[i][j]) {
				j++;
			}else {
				i--;
			}
		}
		return false;
	        
	    }
	  public static void main(String[] args) {
		int nums[][]={{1,4,7,11,15},
					  {2,5,8,12,19},
					  {3,6,9,16,22},
					  {10,13,14,17,24},
					  {18,21,23,26,30}
				};
		SearchMatrix sMatrix=new SearchMatrix();
		System.out.println(sMatrix.searchMatrix(nums, 5));
	}
}
