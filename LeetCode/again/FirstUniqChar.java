import java.util.HashMap;
import java.util.Iterator;

public class FirstUniqChar {
	  public int firstUniqChar(String s) {
		 HashMap<Character, Integer> hMap=new HashMap<Character, Integer>();
		 char[] ch=s.toCharArray();
		 for (int i = 0; i < ch.length; i++) {
			if(hMap.containsKey(ch[i]))
				hMap.put(ch[i], hMap.get(ch[i])+1);
			else
				hMap.put(ch[i],1); 
		}
		for (Iterator<Character> iterator = hMap.keySet().iterator(); iterator.hasNext();) {
			char temp=(char) iterator.next();
			
			if(hMap.get(temp)==1){
				for (int i = 0; i < ch.length; i++) {
					if(ch[i]==temp) return i;
				}
				return -1;
			} 
			
		}
		return -1;
		  
	  }
}
