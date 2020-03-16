package string;

public class ReverseString {
	public String reverseString(String s) {
		String reverse="";
		//第一种  通过String类的charAt()的方法来获取字符串中的每一个字符，然后将其拼接为一个新的字符串。
		
//		for(int i=0;i<s.length();i++)
//			reverse=s.charAt(i)+reverse;
		
		//第二种   通过String的toCharArray()方法可以获得字符串中的每一个字符串并转换为字符数组，然后用一个空的字符串从后向前一个个的拼接成新的字符串。
//		char[] array=s.toCharArray();
//		for(int i=s.length()-1;i>=0;i--)
//			reverse=reverse+array[i];
		//第三种  通过StringBuiler的reverse()的方法，!!!!!最快!!!!的方式。
		StringBuilder sBuilder=new StringBuilder(s);
		reverse=sBuilder.reverse().toString();
		return reverse;
		

	}

	public static void main(String[] args) {
		ReverseString reverseString=new ReverseString();
		String string="abcdfsdsdfdsasdvsdavfsagsdgsdghfsgvsdarwegergfgshijsdgfhjsfvsjhfgvjhsdvfgieruyfvusyafvgdjhgfsdjhgfsjhdgfhjsdvdcbvwueyfgyrguwygfweyufwef5we65f4ew6f123sd1f65er1vfsd6v1a23sd1/greg48etr6jh4y8u64iu86l156;1l3.1l3k15m13v21s321xz3c16F1EWQ65F1265R1EF32G4456G1DF3B1GF32N1J,51IL6./5165PO1;56U.Y1";
		System.out.print(reverseString.reverseString(string));
		
	}
}
