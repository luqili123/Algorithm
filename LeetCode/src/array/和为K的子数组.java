package array;

import java.util.HashMap;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 560 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * @author lqllq
 *
 */
public class 和为K的子数组 {
	public static  int subarraySum(int[] nums, int k) {
		if(nums.length==0||nums==null){
			return 0;
		}
		HashMap<Integer,Integer> hashMap=new HashMap<Integer, Integer>();
		hashMap.put(0, 1);
		int count=0;
		int sum=0;
		for(int i=0;i<nums.length;i++){
			sum+=nums[i];
			
			if(hashMap.containsKey(sum-k)){
				count+=hashMap.get(sum-k);
			}		
			hashMap.put(sum, hashMap.getOrDefault(sum, 0)+1);
		}		
		return count;
        
    }
	public static void main(String[] args) {
		int[] nums={1};
		System.out.println(subarraySum(nums, 0));
	}
}
