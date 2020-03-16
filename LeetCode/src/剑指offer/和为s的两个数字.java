package 剑指offer;
/**
 * 
 *	输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可
 * @author lqllq
 *  思路：双指针逼近，大了r--，小了l++
 */
public class 和为s的两个数字 {
	public int[] twoSum(int[] nums, int target) {
		int l=0;
		int r=nums.length-1;
		while(l<r||(nums[l]+nums[r])!=target){
			if(nums[l]+nums[r]>target){
				r--;
			}else if(nums[l]+nums[r]<target){
				l++;
			}else{
				return new int[]{nums[l],nums[r]};
			}
		}
		return null;
    }
}
