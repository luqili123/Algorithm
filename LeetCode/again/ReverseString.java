
public class ReverseString {
	public String reverseString(String s) {
//		char[] rev=s.toCharArray();
//		String resultString="";
//		for (int k = rev.length-1; k >=0; k--) {
//			resultString+=rev[k];
//		}
//		return resultString;
		StringBuilder sBuilder=new StringBuilder(s);
		return sBuilder.reverse().toString();
		
	}
	public static void main(String[] args) {
		ReverseString reverseString=new ReverseString();
		System.out.println(reverseString.reverseString("123456"));
		
	}
}
