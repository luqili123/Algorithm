package 剑指offer;

import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @author lqllq
 *
 */
public class 数组中出现次数超过一半的数字 {
	 public int majorityElement(int[] nums) {
		 if(nums.length==1){
			 return nums[0];
		 }
		 HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
		 int count=0;
		 for(int i=0;i<nums.length;i++){
			 if(hash.containsKey(nums[i])){
				 count=hash.get(nums[i]);
				 hash.put(nums[i], ++count);
				 if(count>nums.length/2){
					 return nums[i];
				 }
			 }else{
				 hash.put(nums[i], 1);
			 }
		 }
		 return -1;
	 }
}
