
public class StrStr {
	public int strStr(String haystack, String needle) {
		
		char[] hs=haystack.toCharArray();
		char[] nd=needle.toCharArray();
		int i,j,k;
		if (needle == null || needle.equals(""))
			return 0;
		else if (hs.length < nd.length) {
			return -1;
		} else {
		for (i = 0; i < nd.length; i++) {
			if(hs[i]==nd[0]){
				j=i+1;
				for(k=1;k<nd.length&&j<hs.length;k++){
					if(hs[j]==nd[k])
						j++;
					else {
						break;
					}
				}
				if(k==nd.length)
					return i;
			}
		}}
		return -1;
		
	}
}
