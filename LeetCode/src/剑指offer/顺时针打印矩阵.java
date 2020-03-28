package 剑指offer;
/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * @author lqllq
 *	算法流程：
	空值处理： 当 matrix 为空时，直接返回空列表 [] 即可。
	初始化： 矩阵 左、右、上、下 四个边界 l , r , t , b ，用于打印的结果列表 res 。
	循环打印： “从左向右、从上向下、从右向左、从下向上” 四个方向循环，每个方向打印中做以下三件事 （各方向的具体信息见下表） ；
		根据边界打印，即将元素按顺序添加至列表 res 尾部；
		边界向内收缩 11 （代表已被打印）；
		判断是否打印完毕（边界是否相遇），若打印完毕则跳出。
	返回值： 返回 res 即可。

 */
public class 顺时针打印矩阵 {
	public static int[] spiralOrder(int[][] matrix) {
		if(matrix==null||matrix.length==0){
			return new int[0];
		}
		//每次遍历的边界
		//左
		int l=0;
		//右
		int r=matrix[0].length-1;
		//上
		int t=0;
		//下
		int b=matrix.length-1;
		int[] res=new int[(r+1)*(b+1)];
		int index=0;
		while(true){
			//从左到右
			for(int i=l;i<=r;i++){
				res[index++]=matrix[t][i];				
			}
			t++;
			//这里只要有一个条件不满足就要break，因为已经遍历完了，再继续，index就会越界
			if(t>b)break;
			//从上到下
			for(int i=t;i<=b;i++){
				res[index++]=matrix[i][r];			
			}
			r--;
			if(l>r)break;
			//从右向左
			for(int i=r;i>=l;i--){
				res[index++]=matrix[b][i];			
			}
			b--;
			if(t>b)break;
			//从下往上
			for(int i=b;i>=t;i--){
				res[index++]=matrix[i][l];				
			}
			l++;
			if(l>r)break;
		}
		return res;
    }
	public static void main(String[] args){
		int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int[] res=spiralOrder(matrix);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]+" ");
		}
	}
}
