package 剑指offer;

import java.util.HashMap;

/**
 * 	请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 	输入: "abcabcbb"
	输出: 3 
	解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * @author lqllq
 *	思路：两个下标i，j，一个指向当前子字符串开头，另一个指向当前子字符串结尾。
 *		  用map存储当前子串中各个字母出现的数。试探性++j，如果s[j]出现次数达到2，要不断++i以使得s[j]出现次数为1。过程中的最长子串长度作为返回值即可

 */
public class 最长不含重复字符的子字符串 {
	public int lengthOfLongestSubstring(String s) {
		if(s==null||s.equals("")){
			return 0;
		}
		int i=0,j=0;
		HashMap<Character,Integer> hash=new HashMap<Character,Integer>();
		int max=1;
		while(j<s.length()){
			//若当前元素不包含在map中，说明未出现
			char curr=s.charAt(j);
			if(!hash.containsKey(curr)){
				hash.put(curr, 1);			
			}else{//若包含，则说明该元素出现过，需要移动i，直到i到j之间不存在重复
				while(s.charAt(i)!=curr){
					//移动期间需要从map中删除经过的元素，因为i移动后，这些元素都没有出现在子串中了
					hash.remove(s.charAt(i));
					i++;						
				}
				//跳出循环时i就在重复元素的位置
				i++;
			}
			max=Math.max(max, j-i+1);
			j++;			
		}
		return max;
		
    }
}
