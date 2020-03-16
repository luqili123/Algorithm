

public class LongestCommonPrefix {
	// 最长前缀一定不会比字符数组中最短的那个字符串要长，所以首先应该找出最短字符串长度，寻找前缀的循环次数最多就是最多字符串的长度
	// 遍历字符串数组，比较每个元素第i个字符是否相同，若都相同则将这个字符串添加到新字符串最后，最后返回改字符串
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		int minlen = strs[0].length();
		for (int i = 1; i < strs.length; i++) {
			if (minlen > strs[i].length())
				minlen = strs[i].length();
		}
		int j = 0;
		String result="";
		while (j < minlen) {
			for (int k = 0; k < strs.length - 1; k++) {
				if (strs[k].charAt(j) != strs[k + 1].charAt(j)) {
					return result;
				}
			}
			result+=strs[0].charAt(j);
			j++;
		}
		return result;

	}
	public static void main(String[] args) {
		LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
		String[] strings = { "asadcc", "acc", "acc" };
		System.out.print(longestCommonPrefix.longestCommonPrefix(strings));

	}

}
