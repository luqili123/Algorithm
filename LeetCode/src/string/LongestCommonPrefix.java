package string;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		if (strs.length == 1) {
			return strs[0];
		}

		int minlength = strs[0].length();
		for (int i = 1; i < strs.length; i++) {
			if (minlength > strs[i].length())
				minlength = strs[i].length();
		}
		// System.out.print(minlength);
		int n = 0;
		StringBuffer sBuffer = new StringBuffer();
		String result = "";

		while (n < minlength) {
			for (int i = 1; i < strs.length; i++) {
				if (i == strs.length - 1) {
					sBuffer.append(strs[i].charAt(n));
				}
				if (strs[i].charAt(n) == strs[i - 1].charAt(n))
					continue;
				else if (n == 0)
					return "";
				else {

					result = strs[i].substring(0, n);
					return result;
				}

			}
			n++;
		}
		result = sBuffer.toString();
		return result;

	}

	public static void main(String[] args) {
		LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
		String[] strings = { "c", "c", "c" };
		System.out.print(longestCommonPrefix.longestCommonPrefix(strings));

	}
}
