package string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;


public class FirstUniqChar {
	public int firstUniqChar(String s) {
		char[] sc = s.toCharArray();
		HashMap<String, Integer> hashMap = new LinkedHashMap<String, Integer>();//LinkedHashMap有顺序，HashMap没有顺序
		for (int i = 0; i < sc.length; i++) {

			if (hashMap.containsKey(sc[i]+"")) {
				int value = hashMap.get(sc[i]+"") + 1;
				hashMap.put(sc[i] + "", value);
			} else {
				hashMap.put(sc[i] + "", 1);
			}
		}
		Iterator<String> iterator = hashMap.keySet().iterator();
		
		while (iterator.hasNext()) {
			String s2=iterator.next();
			System.out.print(s2);
			System.out.println(hashMap.get(s2));
			if(hashMap.get(s2)==1){
				for(int index=0;index<sc.length;index++){
					if((sc[index]+"").equals(s2)) return index;
				}
				return -1;
			}
			
		}
		return -1;

	}

	public static void main(String[] args) {
		FirstUniqChar firstUniqChar=new FirstUniqChar();
		String string="leetcode";
		System.out.println(firstUniqChar.firstUniqChar(string));
				
	}
}
