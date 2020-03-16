package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Intersection {
	 public int[] intersection(int[] nums1, int[] nums2) {
		 HashMap<Integer, Integer> hashMap=new HashMap<Integer, Integer>();
		 List<Integer> temp=new ArrayList<Integer>();
		 for (int i = 0; i < nums1.length; i++) {
			if(!hashMap.containsKey(nums1[i]))
				hashMap.put(nums1[i], 1);
//			else 
//				hashMap.put(nums1[i], hashMap.get(nums1[i])+1);
		}
		 for (int i = 0; i < nums2.length; i++) {
			if(hashMap.containsKey(nums2[i])&&(hashMap.get(nums2[i])>0)){				
				temp.add(nums2[i]);
				hashMap.put(nums2[i], 0);
			}
		}
		 int[] nums3=new int[temp.size()];
		  int i=0;
		 for (Integer num : temp) {
			nums3[i++]=num;
		 }
		return nums3;
	        
	    }
	 public static void main(String[] args) {
		 Intersection intersection=new Intersection();
		int[] nums1={1,2,2,1};
		int[] nums2={2,2};
		int[] nums3=intersection.intersection(nums1, nums2);
		for (int i : nums3) {
			System.out.println(i+",");
		}
	}
}
