package array;

public class SingleNumber {
	//此题涉及位运算，异或运算为^,相异为1，一个数a对同一个数b做两次异或运算，结果仍然为a，即a^b^b=a
	//此题其他数都是出现两次，所以，单独一个的为a，其余的为b1,b2,b3.....,将所有元素做异或运算之后，结果就是那个单独的元素
	public int singleNumber(int[] nums) {
		int result=nums[0];
		for(int i=1;i<nums.length;i++)
			result=result^nums[i];
		return result;

	}

	public static void main(String[] args) {
		SingleNumber singleNumber=new SingleNumber();
		int[] nums={4,2,2,16,5,5,16};
		
		System.out.print(singleNumber.singleNumber(nums));

	}

}
