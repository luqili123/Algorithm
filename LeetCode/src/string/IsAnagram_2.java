package string;

public class IsAnagram_2 {
	//方法二：字母只有26个，利用一个数组
	//局限性：字符串只能是字母
	public boolean isAnagram(String s, String t) {
		int[] alphabet=new int[26];
		for(int i=0;i<s.length();i++) alphabet[s.charAt(i)-'a']++;
		for(int j=0;j<t.length();j++) alphabet[t.charAt(j)-'a']--;
		for (int i : alphabet) {
			if(i!=0) return false;
			
		}
		return true;
	}
public static void main(String[] args) {
	IsAnagram isAnagram=new IsAnagram();
	String s="leEtcode";
	String t="eEtcoedl";
	System.out.println(isAnagram.isAnagram(s, t));
}
}
	
	
