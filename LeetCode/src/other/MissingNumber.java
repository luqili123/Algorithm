package other;
//我们就简单把这道题当成一道数学题来算就可以了，因为是连续的，所以不缺失数字时候的加和可以计算，
//缺失数字之后的加和遍历一遍也可以计算出来，二者相减不就是缺失的数字了，额
public class MissingNumber {
	
	public int missingNumber(int[] nums) {
		int res=nums.length;
		for (int i = 0; i < nums.length; i++) {
			res=res+i-nums[i];
		}
		return res;
//繁琐了
//		int[] num2 = new int[nums.length + 1];
//		for (int i = 0; i < num2.length; i++) {
//			num2[i] = i;
//		}
//		for (int i = 0; i < nums.length; i++) {
//			num2[nums[i]] = -1;
//		}
//		for (int i : num2) {
//			if (i != -1)
//				return i;
//		}
//		return -1;

	}

	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 4 };
		MissingNumber missingNumber = new MissingNumber();
		System.out.println(missingNumber.missingNumber(a));
	}

}
