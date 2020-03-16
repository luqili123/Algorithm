package dynamic_programming;

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); int param_1 = obj.sumRange(i,j);
 */
public class 区域和检索_数组不可变 {
	private int[] dp = null;

	public 区域和检索_数组不可变(int[] nums) {
		if (nums.length > 0) {
			dp = new int[nums.length + 1];
			dp[0] = 0;
			dp[1] = nums[0];
			for (int i = 1; i <= nums.length; i++) {
				dp[i] = dp[i - 1] + nums[i - 1];
				System.out.print(dp[i] + " ");
			}
		}
	}

	public int sumRange(int i, int j) {
		if (dp != null) {
			return dp[j + 1] - dp[i];
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		int[] nums = { -2, 0, 3, -5, 2, -1 };
		区域和检索_数组不可变 obj = new 区域和检索_数组不可变(nums);
		System.out.println(obj.sumRange(2, 5));

	}
}
