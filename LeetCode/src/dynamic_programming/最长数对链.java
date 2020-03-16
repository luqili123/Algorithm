package dynamic_programming;

import java.util.Arrays;
import java.util.Comparator;

public class 最长数对链 {
	public static int findLongestChain(int[][] pairs) {
		//首先对数组按第一个元素升序排序
		Arrays.sort(pairs,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]){
					return o1[1]-o2[1];
				}else {
					return o1[0]-o2[0];
				}
				
			}		
		});		
//		for(int i=0;i<pairs.length;i++){
//			for(int j=0;j<pairs[i].length;j++){
//				System.out.print(pairs[i][j]+" ");
//			}
//			System.out.println();
//		}
		int[] dp=new int[pairs.length];
		//初始化为1
		Arrays.fill(dp, 1);
		
		//下面的思路与最长递增子序列思路相同
		int max=-1;
		for(int i=1;i<pairs.length;i++){
			for(int j=0;j<i;j++){
				if(pairs[i][0]>pairs[j][1]){
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
		}
		for(int i=0;i<pairs.length;i++){
			max=Math.max(max, dp[i]);
		}
		return max;
        
    }
	public static void main(String[] args) {
		int[][] pairs={{3,4},{2,3},{1,2},{4,5},{5,6}};
		System.out.println(findLongestChain(pairs));
		
	}
}
