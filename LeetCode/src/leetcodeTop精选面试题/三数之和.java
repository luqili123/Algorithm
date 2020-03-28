package leetcodeTop精选面试题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 
	给定数组 nums = [-1, 0, 1, 2, -1, -4]，
	满足要求的三元组集合为：
	[
	  [-1, 0, 1],
	  [-1, -1, 2]
	]

 * @author lqllq
 * 思路：对数组排序，固定一个数的位置i，然后用两个指针分别指向i后面数字的两端，然后移动
 */
public class 三数之和 {
	 public static List<List<Integer>> threeSum(int[] nums) {
		 List<List<Integer>> res=new ArrayList<List<Integer>>();
		 if(nums.length<3){
			 return res;
		 }
		 //首先对数组进行排序
		 Arrays.sort(nums);
		 //固定一个数，移动另外两个指针
		 int sum=-1;
		 for(int i=0;i<nums.length;i++){
			 //数组已经排好序，若i位置元素大于0，则后面所有数都大于0，不需要再看了
			 if(nums[i]>0){ 
				 break;
			 }
			 //相同的数字，不需要计算两次
			 if(i>0&&nums[i]==nums[i-1]){
				 continue;
			 }
			 int l=i+1;
			 int r=nums.length-1;
			 while(l<r){
				sum=nums[i]+nums[l]+nums[r];
				if(sum==0){
					res.add(Arrays.asList(nums[i],nums[l],nums[r]));
					l++;
					r--;
					//去重
					while(l<r&&nums[l]==nums[l-1]){
						l++;
					}
					while(l<r&&nums[r]==nums[r+1]){
						r--;
					}
					
				}else if(sum<0){
					l++;
				}else if(sum>0){
					r--;
				}
			 }
		 }
		 return res;
	 }
	 public static void main(String[] args){
		 int[] h={-1, 0, 1, 2, -1, -4};
		 System.out.print(threeSum(h).toString());
	 }
}
