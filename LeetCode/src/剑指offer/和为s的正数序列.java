package 剑指offer;

import java.util.ArrayList;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
         序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

 * @author lqllq
 * 思路：滑动窗口，和双指针一样，两个指针l和r，记录滑动窗口的位置，sum为窗口内所有元素的和
 */
public class 和为s的正数序列 {
	public static int[][] findContinuousSequence(int target) {
		if(target<3){
			return null;
		}
		ArrayList<int[]> arr=new ArrayList<int[]>();
		int l=1;
		int r=2;
		//sum为窗口内所有元素的和，target至少得是3
		int sum=3;
		//因为至少是两个元素的和，所以r和l不能是相同的数
		while(l<=target&&r-l>0){
			//和小于target，则扩大右边界，同时增加sum
			if(sum<target){
				r++;
				sum+=r;
			//和大于target缩小左边界，同时减少sum
			}else if(sum>target){
				sum-=l;
				l++;
			}else{
				//等于target则将其放入结果集中
				int[] res=new int[r-l+1];
				for(int i=0;i<res.length;i++){
					res[i]=l+i;
				}
				arr.add(res);
				//减少左边界
				sum-=l;
				l++;
			}
		}
		return arr.toArray(new int[arr.size()][]);
    }
	public static void main(String[] args){
		int[][] res=findContinuousSequence(9);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
	}
}
