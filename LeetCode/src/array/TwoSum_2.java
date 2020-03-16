package array;
//使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
public class TwoSum_2 {
	public int[] twoSum(int[] numbers, int target){
		int i=0;
		int j=numbers.length-1;
		int[] result=new int[2];
		while (i<j) {
			
			if(numbers[i]+numbers[j]<target){
				i++;
				
			}
			else if(numbers[i]+numbers[j]>target){
				j--;
				
			}
			else if(numbers[i]+numbers[j]==target){
				result[0]=numbers[i];
				result[1]=numbers[j];
				return result;
			}
		}
		return null;
		
	}
	public static void main(String[] args) {
		TwoSum_2 twoSum_2=new TwoSum_2();
		int[] nums={2,3,4,6,7};
		int[] result=twoSum_2.twoSum(nums, 11);
		System.out.println(result[0]+" "+result[1]);
		
	}
}
