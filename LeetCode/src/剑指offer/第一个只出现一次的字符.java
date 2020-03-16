package 剑指offer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 * @author lqllq
 *
 */
public class 第一个只出现一次的字符 {
	/**
	 * 使用hashmap记录出现过的字符，用arraylist记录未重复的字符
	 * @param s
	 * @return
	 */
	public char firstUniqChar(String s) {
		if(s.equals("")){
			return ' ';
		}
		HashMap<Character,Integer> hash=new HashMap<>();
		ArrayList<Character> arr=new ArrayList<>();
		for(int i=0;i<s.length();i++){
			char t=s.charAt(i);
			//map里没有钙元素，说明元素是第一次出现
			if(!hash.containsKey(t)){
				hash.put(t, 1);
				arr.add(t);
			}else{//map中有这个元素,说明这个元素不止出现一次
				//当前的值为1，说明当前是第二次出现，该元素还在arr中，将其删除，值++
				if(hash.get(t)==1){
					arr.remove(arr.indexOf(t));
					hash.put(t, 2);
				}else{//这里说明该元素出现超过两次，之前已经从arr中删除了，其实啥也不用做
					
				}
			}
		}
		//最后，arr的第一个元素就是结果
		if(arr.size()==0){
			return ' ';
		}
		return arr.get(0);
		
    }
	
	/**
	 * 字典法：
	 * 字母最多26个，可以直接建立一个长度为26的数组，数组中记录s中各字母出现的次数。然后再遍历s，对照数组，找到第一个出现次数为1的字符
	 * @param s
	 * @return
	 */
	public char firstUniqChar2(String s) {
		if(s.equals("")){
			return ' ';
		}
		int[] count=new int[26];
		char[] t=s.toCharArray();
		for(char c:t){
			count[c-'a']++;
		}
		for(char c:t){
			if(count[c-'a']==1){
				return c;
			}
			
		}
		return ' ';
	}
}
