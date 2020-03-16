import java.util.HashSet;

public class ContainsDuplicate {
	//利用HashSet的唯一性，在每次添加的时候检查返回值来进行判断,效率不如循环
	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> jHashSet=new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(!jHashSet.add(nums[i])) return true;
		}
		return false;
		
	}
}
