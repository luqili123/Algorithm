package string;

public class ReverseWords {
	public String reverseWords(String s) {
		String[] strings=s.split(" ");
		String temp,result="";
		
		for (int i = 0; i < strings.length; i++) {
			StringBuilder stringBuilder=new StringBuilder(strings[i]);
			temp=stringBuilder.reverse().toString();
			if(i==strings.length-1)
				result+=temp;
			else {
				result+=temp+" ";
			}
		}
		return result;

	}
	public static void main(String[] args) {
		String string="abc BC ba abc";
		ReverseWords reverseWords=new ReverseWords();
		System.out.println(reverseWords.reverseWords(string));
	}
}
