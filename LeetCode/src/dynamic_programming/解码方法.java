package dynamic_programming;

public class 解码方法 {
	public static int numDecodings(String s) {
		if (s.charAt(0) == '0')
			return 0;
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			if (s.charAt(i - 1) == '0') {
				if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2') {
					dp[i] = dp[i - 2];
				} else {
					return 0;
				}
			} else {
				if (s.charAt(i - 2) == '1'
						|| (s.charAt(i - 2) == '2' && s.charAt(i - 1) > '0' && s.charAt(i - 1) <= '6')) {
					dp[i] = dp[i - 1] + dp[i - 2];
				} else {
					dp[i] = dp[i - 1];
				}
			}
		}
		return dp[s.length()];
	}
	
	public static int numDecodings2(String s) {
		if (s.charAt(0) == '0')
			return 0;
		int pre1=1;//dp[i-1]
		int pre2=1;//dp[i-2]
		int curr=1;
		for(int i=1;i<s.length();i++){
			if (s.charAt(i) == '0') {
				if (s.charAt(i-1) == '1' || s.charAt(i - 1) == '2') {
					curr=pre2;
				} else {
					return 0;
				}
			} else {
				if (s.charAt(i - 1) == '1'|| (s.charAt(i - 1) == '2' && s.charAt(i) > '0' && s.charAt(i) <= '6')) {
					curr=pre1+pre2;
				} else {
					curr=pre1;
				}
			}
			pre2=pre1;
			pre1=curr;
		}
		return curr;
	}
	public static void main(String[] args) {
		String s = "227";
		System.out.println(numDecodings2(s));
	}
}
