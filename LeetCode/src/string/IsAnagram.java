package string;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class IsAnagram {
public boolean isAnagram(String s, String t) {
	char[] sc=s.toCharArray();
	char[] tc=t.toCharArray();
	HashMap<String, Integer> hashMap_s = new LinkedHashMap<String, Integer>();//LinkedHashMap有顺序，HashMap没有顺序
	HashMap<String, Integer> hashMap_t=new LinkedHashMap<String, Integer>();
	for (int i = 0; i < sc.length; i++) {

		if (hashMap_s.containsKey(sc[i]+"")) {
			int value = hashMap_s.get(sc[i]+"") + 1;
			hashMap_s.put(sc[i] + "", value);
		} else {
			hashMap_s.put(sc[i] + "", 1);
		}
	}
	for (int i = 0; i < tc.length; i++) {

		if (hashMap_t.containsKey(tc[i]+"")) {
			int value = hashMap_t.get(tc[i]+"") + 1;
			hashMap_t.put(tc[i] + "", value);
		} else {
			hashMap_t.put(tc[i] + "", 1);
		}
	}
		if(hashMap_s.equals(hashMap_t))return true;
	
	return false;
        
    }
public static void main(String[] args) {
	IsAnagram isAnagram=new IsAnagram();
	String s="leetcode";
	String t="eetcoedl";
	System.out.println(isAnagram.isAnagram(s, t));
}
}
