package array;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		for(int i=0;i<nums.length-1;i++){
			for(int j=i+1;j<nums.length;j++){
				if(nums[i]==nums[j])
					return true;
			}
		}
		
		return false;

	}

	public static void main(String[] args) {
		ContainsDuplicate containsDuplicate=new ContainsDuplicate();
		int[] nums={123,1,2,3,4,5,6,3};
		
		System.out.print(containsDuplicate.containsDuplicate(nums));
	}
}
