package string;

public class StrStr {
	public int strStr(String haystack, String needle) {
		char[] hc = haystack.toCharArray();
		char[] nc = needle.toCharArray();
		int i, j ,k;
		if (needle == null || needle.equals(""))
			return 0;
		else if (hc.length < nc.length) {
			return -1;
		} else {
			for(i=0;i<hc.length;i++){
				if(hc[i]==nc[0]){
					j=i+1;
					k=1;
					for(;k<nc.length&&j<hc.length;k++){
						if(hc[j]==nc[k])
							j++;
						else {
							break;
						}
					}
					if(k==nc.length)
						return i;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		StrStr str=new StrStr();
		String  haystack = "hel", needle = "l";
		
		System.out.println(str.strStr(haystack, needle));
		}
}
