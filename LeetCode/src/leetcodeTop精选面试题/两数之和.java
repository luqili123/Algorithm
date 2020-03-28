package leetcodeTop精选面试题;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
	你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 	示例:
	给定 nums = [2, 7, 11, 15], target = 9
	因为 nums[0] + nums[1] = 2 + 7 = 9
	所以返回 [0, 1]
 * @author lqllq
 * 使用hash表记录所有元素，value为数组下标，key为元素值，然后temp=target-nums[i]重新遍历数组，利用hash查找时间O（1）的特点，看数组中有没有等于
 * temp的元素
 */
public class 两数之和 {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
		//	将数组元素存入map中，重复元素的下标i会被覆盖
		for(int i=0;i<nums.length;i++){
			hash.put(nums[i], i);
		}
		int temp;
		for(int i=0;i<nums.length;i++){
			temp=target-nums[i];
			if(hash.containsKey(temp)&&hash.get(temp)!=i){
				return new int[]{i,hash.get(temp)};
			}
		}
		return new int[]{};
    }
}
