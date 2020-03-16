package oj;

/**
 * 题目描述：给定一个数组arr，数组中的元素有整数也有负数，数组中的一个或者连续多个数组成一个子数组。
 * 求所有子数组里面的最大和。例如现在有数组 {1 ， -2 ， 3 ， 10 ， -4 ， 7 ， 2 ， -5 }。
 * 
 * 动态规划思想。状态方程 ： max( dp[ i ] )  = getMax(  max( dp[ i -1 ] ) + arr[ i ] ,arr[ i ] ) 
 * 
 * @author lqllq
 *
 */
public class 连续子数组的最大和 {
	public static  int FindMaxSumOfSubArray(int[] array){
		int thisSum=array[0];
		int max=array[0];
		for(int i=1;i<array.length;i++){
			thisSum+=array[i];
			if(thisSum>max){
				max=thisSum;
			}else if (thisSum<0) {
				thisSum=0;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		int[] array={1,-2,0,3};
		System.out.println(FindMaxSumOfSubArray(array));
	}
}	
