package math;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class MajorityElement {
	 public int majorityElement(int[] nums) {
		 HashMap<Integer, Integer> hashMap=new HashMap<Integer, Integer>();
		 for (int i = 0; i < nums.length; i++) {
			if(hashMap.containsKey(nums[i]))
				hashMap.put(nums[i], hashMap.get(nums[i])+1);
			else {
				hashMap.put(nums[i], 1);
			}
		}
		 for (Iterator<Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator(); iterator.hasNext();) {
			 Entry<Integer, Integer> entry=iterator.next();
			 int num=entry.getKey();
			int count=entry.getValue() ;
			if(count>nums.length/2) return num;
		}
		return -1;
	        
	    }
	 public static void main(String[] args) {
		MajorityElement majorityElement=new MajorityElement();
		int[] nums={1,2,3,4,4,4,4};
		System.out.println(majorityElement.majorityElement(nums));
		
	}
}
