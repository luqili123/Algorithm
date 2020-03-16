package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sun.javafx.collections.MappingChange.Map;

/*
 * 思路：
　　1、增加一个计数器，用来记录其中一个数组元素出现的次数。
　　2、遍历另一个数组，如果该数组元素在计数器中有记录且记录的次数大于1，将该数字新增到结果数组中，同时计数器该数字记录的次数减1。
*/
public class Intersect {
	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<nums1.length;i++){//将nums1中的元素存入hashmap中，key值 为数组元素，对应的value为该元素出现的次数
			int nums=nums1[i];
			if(map.containsKey(nums))
				map.put(nums,map.get(nums)+1);
			else {
				map.put(nums, 1);
			}
		}
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<nums2.length;i++){
			int num=nums2[i];
			if(map.containsKey(num)&&map.get(num)>0){//若nums2中的元素在map中，且value大于0说明这个元素是交集
				map.put(num, map.get(num)-1);
				list.add(num);
			}
		}
		int[] result=new int[list.size()];
		for(int i=0;i<result.length;i++){
			result[i]=list.get(i);
		}
		return result;
		
	
	}

	public static void main(String[] args) {
		Intersect intersect=new Intersect();
		int[] nums1={1,2,2,1};
		int[] nums2={2,2};
		int[] res=intersect.intersect(nums1, nums2);
		for (int i : res) {
			System.out.print(i+" ");
		}
	}
}
