package 剑指offer;
/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
示例 1：
输入: "the sky is blue"
输出: "blue is sky the"
 * @author lqllq
 * 无空格字符构成一个单词。
	输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
	如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

 */
public class 翻转单词顺序 {
	public static String reverseWords(String s) {
		if(s==null||s.equals("")){
			return s;
		}
		String[] t=s.split(" ");
		StringBuilder sb=new StringBuilder("");
		//拼接字符串
		for(int i=t.length-1;i>=0;i--){
			//若s有多个连续空格，t[i]会等于""
			if(!t[i].equals(""))
				sb.append(t[i]).append(" ");
		}
		
		return sb.toString().trim();
    }
	public static void main(String[] args){
		System.out.print(reverseWords("  hello world!  "));
		
	}
}

