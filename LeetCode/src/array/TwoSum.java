package array;

public class TwoSum {
	public  int[] twoSum(int[] nums, int target) {
		int[] result=new int[2];
		for(int i=0;i<nums.length;i++){
			for(int j=i+1;j<nums.length;j++){
				if(target==nums[i]+nums[j])
				{
					result[0]=i;
					result[1]=j;
					return result;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		TwoSum twoSum=new TwoSum();
		int[] nums={2, 7, 11, 15};
		int[] result=twoSum.twoSum(nums, 9);
		for (int i : result) {
			System.out.print(i+",");
		}
		
	}
}
