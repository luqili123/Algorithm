package array;

public class RotateMatrix {
	public void rotate(int[][] matrix) {
		//方法1：对于当前位置，计算旋转后的新位置，然后再计算下一个新位置，第四个位置又变成当前位置了，所以这个方法每次循环换四个数字
		int length=matrix.length;
//		System.out.println(length);
		for(int i=0;i<length/2;i++){
			for(int j=i;j<length-1-i;j++){
				int tmp = matrix[i][j];
                matrix[i][j] = matrix[length - 1 - j][i];
                matrix[length - 1 - j][i] = matrix[length - 1 - i][length - 1 - j];
                matrix[length - 1 - i][length - 1 - j] = matrix[j][length - 1 - i];
                matrix[j][length - 1 - i] = tmp;
			}
		}
		//方法二：首先以从对角线为轴翻转，然后再以x轴中线上下翻转即可得到结果，如下图所示(其中蓝色数字表示翻转轴)：
//     	System.out.print(matrix.length);
	}

	public static void main(String[] args) {
		int[][] test1 = new int[][]{
            {1, 2, 3,4},
            {4, 5, 6,4},
            {7, 8, 9,4},
            {1,2, 3, 4}
    };
		RotateMatrix rotateMatrix=new RotateMatrix();
		rotateMatrix.rotate(test1);
		for(int i=0;i<test1.length;i++){
			System.out.println();
			for(int j=0;j<test1.length;j++){
				System.out.print(test1[i][j]);
			}
			}
	}
}
