
public class IsPalindrome {
	public boolean isPalindrome(String s) {
		String str=s.toLowerCase();
		int i=0,j=s.length()-1;
		while (i<j) {
			char ch1=str.charAt(i),ch2=str.charAt(j);
			if(ch1>'z'||ch1<'a')
				i++;
			else if (ch2>'z'||ch2<'z') {
				j--;
			}else if (ch1!=ch2) {
				return false;
			}
			i++;
			j--;
		}
		return true;
		
	}
}
