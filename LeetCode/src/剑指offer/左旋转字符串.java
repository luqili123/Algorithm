package 剑指offer;
/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * @author lqllq
 *
 */
public class 左旋转字符串 {
	public static String reverseLeftWords(String s, int n) {
		if(s==null||s.equals("")){
			return s;
		}
		String t1=s.substring(0,n);
		String t2=s.substring(n,s.length());
		return t2+t1;
    }
	public static void main(String[] args){
		System.out.print(reverseLeftWords("abcdref",6));
		
	}
}
