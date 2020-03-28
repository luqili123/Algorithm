package leetcodeTop精选面试题;

import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author lqllq
 * 输入: "abcabcbb"
        输出: 3 
      解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class 无重复字符的最长子串长度 {
	 public static  int lengthOfLongestSubstring(String s) {
		 if(s==null||s.length()==0){
			 return 0;
		 }
		 int i=0;
		 int j=1;
		 //不重复子串的长度
		 int len=1;
		 //最大长度
		 int max=1;
		 HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		 map.put(s.charAt(0), 1);
		 while(j<s.length()){
			 //若map中存在该元素，则说明重复了
			 if(map.containsKey(s.charAt(j))){
				 while(i<j){
					 if(s.charAt(i)==s.charAt(j)){
						i++;
						break;
					 }
					 map.remove(s.charAt(i));
					 i++;
					 len--;
				 }
			 }else{
				 len++;
				 map.put(s.charAt(j), 0);
			 }
			 j++;
			 
			 if(len>max){
				 max=len;
			 }
		 }
		 return max;
		 
	 }
	 public static void main(String[] args){
		 String s="pwwkew";
		 System.out.print(lengthOfLongestSubstring(s));
	 }
}
