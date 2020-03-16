package dynamic_programming;

public class 判断子序列 {
	public static boolean isSubsequence(String s, String t) {
		int x = s.length();
		int y = t.length();
		boolean[][] dp = new boolean[x + 1][y + 1];
		for (int i = 0; i <= y; i++) {
			dp[0][i] = true;
		}

		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= y; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = dp[i][j - 1];
				}
			}

		}
		return dp[x][y];
	}
	public static  boolean isSubsequence2(String s, String t) {
		if(s.equals("")){
			return true;
		}
		int index=0;
		
		for(int i=0;i<t.length();i++){
			
			if(t.charAt(i)==s.charAt(index)){
				index++;
			}
			if(index==s.length()){
				return true;
			}
		}
	
		return false;
    }
	public static void main(String[] args) {
		System.out.println(isSubsequence2("abc","ahbgdc"));
		
	}

}
