package string;

import java.util.HashMap;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class CanConstruct {
	public boolean canConstruct(String ransomNote, String magazine) {
		HashMap<Character, Integer> hashMap=new HashMap<Character, Integer>();
		char temp;
		for(int i=0;i<magazine.length();i++){
			temp=magazine.charAt(i);
			if(!hashMap.containsKey(temp))
				hashMap.put(temp, 1);
			else {
				hashMap.put(temp, hashMap.get(temp)+1);
			}
		}
		for(int i=0;i<ransomNote.length();i++){
			temp=ransomNote.charAt(i);
			if(!hashMap.containsKey(temp)||(hashMap.containsKey(temp)&&hashMap.get(temp)<=0))
				return false;
			else {
				hashMap.put(temp, hashMap.get(temp)-1);
			}
		}
		return true;

	}
	public static void main(String[] args) {
		CanConstruct canConstruct=new CanConstruct();
		String ransomNote="cc";
		String magazine="aabbca";
		System.out.println(canConstruct.canConstruct(ransomNote, magazine));
	}
}
