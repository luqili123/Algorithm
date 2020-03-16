package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 三数之和 {
	 public static List<List<Integer>> threeSum(int[] nums) {
	     int k,i,j;
	    
	     List<List<Integer>> res=new ArrayList<List<Integer>>();
	     //先对数组进行排序
	     Arrays.sort(nums);
	     int sum=0;
	     //设置指针位置,并移动指针
	     for(k=0;k<nums.length-2;k++){
	    	 i=k+1;
	    	 j=nums.length-1;
	    	 if(nums[k]>0)
	    		 break;
	    	 if(k>0&&nums[k]==nums[k-1]){
	    		 continue;
	    	 }
	    	 while(i<j){
	    		sum=nums[k]+nums[i]+nums[j];
	    		if(sum>0){
	    			j-=1;
	    		}else if (sum<0) {
					i+=1;
				}else {
					ArrayList<Integer> arrayList=new ArrayList<Integer>();
					arrayList.add(nums[k]);
					arrayList.add(nums[i]);
					arrayList.add(nums[j]);
					res.add(arrayList);
					i+=1;
					j-=1;
					while(i<j&&nums[i]==nums[i-1])
						i+=1;
					while(i<j&&nums[j]==nums[j+1])
						j-=1;
				}
	    	}
	     }
	     return res;
	 }
	 public static void main(String[] args) {
		int[]  nums ={0,0,0,0,0};
		List<List<Integer>> res=threeSum(nums);
		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i).toString());
			
		}
	}
}
