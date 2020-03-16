package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 你能在线性时间复杂度内解决此题吗？
 * @author lqllq
 * 思路：每次移动之后去扫描找最大值效率不高。可以使用双端队列，并维持队列单调递减，当滑动窗口移动时，拿新加入的元素和队尾比较，若比队尾小，直接加入，
 *  	 若大于队尾则弹出队尾元素，知道找到合适位置加入。窗口移动时，若当前队头的元素被移出了窗口，则从队头弹出元素。队列中存储下标即可。
 */
public class 滑动窗口的最大值 {
	public static  int[] maxSlidingWindow(int[] nums, int k) {
		if(nums==null||nums.length==0){
			return new int[]{};
		}
		ArrayList<Integer> arr=new ArrayList<>();
		LinkedList<Integer> q=new LinkedList<>();
		for(int i=0;i<nums.length;i++){
			//大于队尾元素则弹出队尾元素
			while(!q.isEmpty()&&nums[q.peekLast()]<nums[i]){
				q.pollLast();
			}
			//队列为空或者当前元素小于队尾元素时，将该元素加入队列
			q.add(i);
			//查看队头元素有没有出滑动窗口边界
			while(q.peekFirst()<i-k+1){
				q.pollFirst();
			}
			//需要等到滑动窗口完全成型才开始统计，因为现在是从0位置开始的，滑动窗口长度为k，还没有完全出现
			if(i>=k-1){
				arr.add(nums[q.peekFirst()]);
			}
			
//			for(int t:q){
//				System.out.print(nums[t]+" ");
//			}
//			System.out.println();
		}
		int[] res=new int[arr.size()];
		for(int i=0;i<arr.size();i++){
			res[i]=nums[arr.get(i)];
		}
		return res;	
    }
	public static void main(String[] args){
		int[] nums={1,3,-1,-3,5,3,6,7};
		int[] res=maxSlidingWindow(nums,3);
		for(int i=0;i<res.length;i++){
			System.out.print(res[i]+" ");
		}
	}
}
