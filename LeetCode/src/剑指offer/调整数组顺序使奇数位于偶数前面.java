package 剑指offer;
/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * @author lqllq
 * 快速排序
 */
public class 调整数组顺序使奇数位于偶数前面 {
	public static int[] exchange(int[] nums) {
		if(nums==null){
			return null;
		}
		if(nums.length==0){
			return nums;
		}
		int temp=nums[nums.length-1];
		int l=0;
		int r=nums.length-1;
		while(l<r){
			while(l<r&&nums[l]%2!=0){
				l++;
			}
			if(l<r&&nums[l]%2==0){
				nums[r]=nums[l];
				r--;
			}
			while(l<r&&nums[r]%2==0){
				r--;
			}
			if(l<r&&nums[r]%2!=0){
				nums[l]=nums[r];
				l++;
			}			
		}
		nums[r]=temp;
		return nums;
    }
	public static void main(String[] args){
		int[] nums={1,3,5};
		exchange(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
	}
	
}
