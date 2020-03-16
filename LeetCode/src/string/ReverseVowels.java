package string;

import java.util.Arrays;
import java.util.HashSet;

//反转元音字母
//使用双指针指向待反转的两个元音字符，一个指针从头向尾遍历，一个指针从尾到头遍历。
//方法：非元音字母按正常顺序存入数组，元音字母相反的顺序存入数组
public class ReverseVowels {
	public String reverseVowels(String s) {
		HashSet<Character> vowels =new HashSet<Character>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));//返回一个受指定数组支持的固定大小的列表。
		int i=0,j=s.length()-1;
		char[] result=new char[s.length()];
		while(i<=j){
		char ci=s.charAt(i);
		char cj=s.charAt(j);
		if(!vowels.contains(ci))
			result[i++]=ci;
		else if (!vowels.contains(cj)) {
			result[j--]=cj;
		}
		else {
			result[i++]=cj;
			result[j--]=ci;
		}
		}
		return new String(result);//String的构造方法，用数组构造一个字符串
		
	}
	public static void main(String[] args) {
		ReverseWords reverseWords=new ReverseWords();
		String dString="Aa";
		System.out.println(reverseWords.reverseWords(dString));
	}
}
