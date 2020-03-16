package array;

public class SearchInsert {
	public int searchInsert(int[] nums, int target) {

		for (int i = 0; i < nums.length; i++) {
			if(i==nums.length-1) return nums.length;
			else if (nums[i]<target) {
				continue;
			}else if (nums[i]>target) {
				return i-1;
				
			}else if (nums[i]==target) {
				return i;
			}

		}
		return -1;
		

	}
	public static void main(String[] args) {
		int[] nums={1,2,5,6};
		SearchInsert sInsert=new SearchInsert();
		System.out.println(sInsert.searchInsert(nums,2));
		String aString="abcd";
		System.out.println(aString.charAt(aString.length()-1));
				
	}
}
