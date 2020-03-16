package string;

import java.util.HashMap;

public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		HashMap<Character, String> hashMap=new HashMap<Character, String>();
		String[] strings=str.split(" ");
		char[] chars=pattern.toCharArray();
		if(chars.length!=strings.length) return false;
//		for (int i = 0; i < chars.length; i++) {
//			System.out.println(strings[i]);
//			System.out.println(chars[i]);
//		}
		for (int i = 0; i < chars.length; i++) {
			if(!hashMap.containsKey(chars[i])&&!hashMap.containsValue(strings[i])){
				hashMap.put(chars[i], strings[i]);
			}else if(!hashMap.containsKey(chars[i])&&hashMap.containsValue(strings[i])){
				return false;
			}else if (hashMap.containsKey(chars[i])) {
				if(!hashMap.get(chars[i]).equals(strings[i]))
					return false;
			}
		}
		
		return true;
        
    }
	public static void main(String[] args) {
		WordPattern wPattern=new WordPattern();
		String str1="abba";
		String str2="dog dog dog dog";
		System.out.println(wPattern.wordPattern(str1, str2));
	}
}
