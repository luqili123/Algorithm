package array;

import java.util.HashMap;
import java.util.Iterator;

public class ContainsNearbyDuplicate {
	// 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j
	// 的差的绝对值最大为 k。
	// 暴力方法：两个指针，一个指向第一个元素，一个指向最后一个元素，后面的指针不断往前移动，当遇到与前一个指针相同元素的值时，计算索引差j-i,
	// 若j-i<=k则返回true，若不是则后面的指针继续移动，知道i和j相遇，第一轮结束
	// 第二轮，i向后移动一个，继续上面的操作，知道i移动到nums.length-k-1的位置
	
	//HashMap方法：每次存入数值钱先看一下有没有这个数了，如果已经有了，那么看一下这两个数的索引下标之差是不是小于等于k的，
	//如果是的话那么久说明找到了，返回true，如果没有找到就返回false。
	public boolean containsNearbyDuplicate(int[] nums, int k) {
	
//		int j=nums.length-1;
//		int n;
//		for(int i=0;i<nums.length;i++){
//			while (i<j) {
//				if(nums[i]==nums[j]){
//					if(j-i<=k) return true;									
//			}
//				j--;
//			
//		}
//			j=nums.length-1;
//
//	}
//		return false;
		
		//HashMap
		HashMap<Integer, Integer> hashMap=new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(!hashMap.containsKey(nums[i]))
				hashMap.put(nums[i], i);
			else if(hashMap.containsKey(nums[i])){
				if(Math.abs(hashMap.get(nums[i])-i)<=k) return true;
				else hashMap.put(nums[i], i);
			}
		}
		return false;
}
	public static void main(String[] args) {
		ContainsNearbyDuplicate cNearbyDuplicate=new ContainsNearbyDuplicate();
		int[] nums={1,0,1,1};
		System.out.println(cNearbyDuplicate.containsNearbyDuplicate(nums, 1));
	}
}
