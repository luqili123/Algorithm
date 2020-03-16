package 剑指offer;
/**
 * 统计一个数字在排序数组中出现的次数。
 * 输入: nums = [5,7,7,8,8,10], target = 8
	输出: 2
 * @author lqllq
 *	思路：二分法，先找左边界，再找右边界
 */
public class 在排序数组中查找数字1 {
	public int search(int[] nums, int target) {
		if(nums==null||nums.length==0){
			return 0;
		}
		int left=findLeft(nums,target);
		if(left==-1){
			return 0;
		}
		int right=findRight(nums,target);
		return right-left+1;
    }
	public int findLeft(int[] nums,int target){
		int left=0;
		int right=nums.length-1;
		int mid;
		while(left<right){
			mid=(left+right)/2;
			// mid 以及 mid 左边都不是，下一轮搜索区间在 [mid + 1, right]
			if(nums[mid]<target){
				left=mid+1;
			}else if(nums[mid]>target){
				// mid 以及 mid 右边都不是，下一轮搜索区间在 [left, mid - 1]
				right=mid-1;
			}else{// mid 可能是，mid 右边一定不是，下一轮搜索区间在 [left, mid]
				right=mid;
			}
		}
		//会有不存在target的情况
		if(nums[left]==target){
			return left;
		}
		return -1;
	}
	public int findRight(int[] nums,int target){
		int left=0;
		int right=nums.length-1;
		int mid;
		while(left<right){
			//这里有个区别，整数除法默认向下取整，想要找到右边界，这里需要+1
			mid=(left+right+1)/2;
			if(nums[mid]<target){
				left=mid+1;
			}else if(nums[mid]>target){
				right=mid-1;
			}else{
				left=mid;
			}
		}
		////这里不需要考虑不存在情况了，这里暂时保留
		if(nums[right]==target){
			//这里返回left或right都是一样的，跳出循环的条件就是left==right
			return right;
		}
		return -1;
	}
}
