package string;

public class IsIsomorphic {
	//同构字符串例如：add,egg，ascll码最多有256个字符，我们建立s到t与t到s间的索引
	public boolean isIsomorphic(String s, String t) {
		int[] st=new int[256];
		int[] ts=new int[256];
		for (int i = 0; i < s.length(); i++) {
			if(st[s.charAt(i)]==0)
				st[s.charAt(i)]=t.charAt(i);
			if(ts[t.charAt(i)]==0)
				ts[t.charAt(i)]=s.charAt(i);
			if(st[s.charAt(i)]!=t.charAt(i)||ts[t.charAt(i)]!=s.charAt(i))
				return false;
		}
		return true;

	}
	public static void main(String[] args) {
		String s="add";String t="egg";
		IsIsomorphic isIsomorphic=new IsIsomorphic();
		System.out.println(isIsomorphic.isIsomorphic(s, t));
	}
}
