package list;

import java.util.LinkedList;

/**
 * 给定数组arr和整数num，求arr的连续子数组中满足：其最大值减去最小值的结果大于num的个数。请实现一个时间复杂度为O(length(arr))的算法。
 * @author lqllq
 *
 */


import java.util.*;
public class MaxSubArray {
	
	int n ,m ,ans;
	private int left[]; //用来处理每根柱子左边第一根比它小的柱子的位置
	private int right[];//用来处理每根柱子右边第一根比它小的柱子的位置
	private int height[]; //用来存储柱子的高度
	LinkedList<Integer>stack;
	
	MaxSubArray(int n, int m){
		
	   this.n= n;
	   this.m = m;
	   stack = new LinkedList<Integer>();
	   left = new int[m + 2];
	   right = new int [m+2];
	   height = new int[ m+2 ];
	   
	}
	
	public int getMax(int [][]array) {
		
		int max =-1;
		for(int i =  0 ;i < n ;i++) {
			
            //求第i行为底的各个柱子高度
			for(int j = 0 ;j < m ;j++) {
				
				height[j] = (array[i][j] == 1? height[j]+1 : 0);
			}
			
   
 
			int temp = getCurMax(i); //求以当前行为底的直方图中的最大矩形面积
 
			max = temp> max? temp: max;		
			
		}
		
	
 
		return max;
	}
	
	public int getCurMax(int i) {  //用来得到以当前行为底的最大矩形高度
		
		
		int max = -1;
		for(int j = 0 ;j < m ;j++) {
			
			while(!stack.isEmpty()&& height[stack.peek()] >= height[j]) {
				
				right[stack.pop()] = j;
			}
			
			if(!stack.isEmpty()) {
				left[j] = stack.peek();
			}else {
				
				left[j] = -1;
			}
			
			stack.push(j);
		}
			
			while(!stack.isEmpty()) {
				
				right[stack.pop()] = -1;
			}
			
			
			for(int j = 0 ;j < m ;j++) {
				
				
				if(left[j]!=-1 && right[j]!=-1) 
					max = height[j]*(right[j]  - left[j] - 1 ) > max? height[j]*(right[j] - left[j] - 1) :max  ;
	
				else if(left[j] == -1 && right[j] ==-1) 
					max = height[j]*m  > max? height[j]*m:max;
		
				else if(right[j] ==-1) 
					max =  height[j]*(m  - left[j] - 1) >max? height[j]*(m - left[j] -1):max ;
			
				else if(left[j] == -1) 
				   max  =  height[j]*right[j] >max? height[j]*right[j] :max;
				   
 
			}
			
			return max;	
		 
  }
	
	public static void main(String []args) {
		
		Scanner cin = new Scanner(System.in);
		int n,m,x;
		x=n = cin.nextInt();
		for(int q=0;q<x;q++){
			n = cin.nextInt();
			m = cin.nextInt();
			int array[][] = new int[n + 2][m +2];
	 
			for(int i = 0 ; i < n ;i++) {
				for(int j = 0 ;j < m ;j++) {
				 
					array[i][j] = cin.nextInt();
					
				}
				
			}
			
			MaxSubArray mySubArray = new MaxSubArray(n,m);
			System.out.println( mySubArray.getMax(array) );
		
		}
		
		
		
	}
 
}
