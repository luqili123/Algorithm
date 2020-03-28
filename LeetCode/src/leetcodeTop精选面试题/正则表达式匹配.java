package leetcodeTop精选面试题;
/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
	'.' 匹配任意单个字符
	'*' 匹配零个或多个前面的那一个元素
	所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
	
	说明:
	s 可能为空，且只包含从 a-z 的小写字母。
	p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
	
	示例 1:	
	输入:
	s = "aa"
	p = "a"
	输出: false
	解释: "a" 无法匹配 "aa" 整个字符串。
	
	s = "aa"
	p = "a*"
	输出: true
	解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。

 * @author lqllq
 *	思路：https://leetcode-cn.com/problems/regular-expression-matching/solution/zheng-ze-biao-da-shi-pi-pei-by-leetcode/
 */
public class 正则表达式匹配 {
	 public static boolean isMatch(String s, String p) {
		 if(p.length()==0&&s.length()==0)
			 return true;
		 //只要第一个字符相等或者p为.才可以匹配成功.这里需要判断s和p长度是否为0，例如:s=aaa,p=a*或者s=aa,p=a,这种情况，不判断就会导致下标越界
		 boolean match=s.length()>0&&p.length()>0&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.');
		 //考虑*的问题,信号只能出现在第二个位置
		 if(p.length()>=2&&p.charAt(1)=='*'){
			 //如果有星号，两种情况
			 //第一种，s的字符和*前的字符没有匹配上，那么，我们选择忽略*和他前面的字符
			 //第二种，s和*匹配上了，由于*可以代表多个相同字符，所以，此时需要将s已经匹配上的那个字符移除，继续拿后一个字符和*好匹配
			 return isMatch(s,p.substring(2))||(match&&isMatch(s.substring(1),p));			 
			 //错误写法，不管是否匹配上，都要进行两种情况的判断,例如：s=aaa,p=a*a,用下面的写法，返回false
//			 if(!match){
//				 return isMatch(s,p.substring(2));
//			 }else{ 
//				
//				 return isMatch(s.substring(1),p);
//			 }			
		 }else{//如果没有*，则正常匹配
			 return match&&isMatch(s.substring(1),p.substring(1));
		 }
	 }
	 public static void main(String[] args){
		 System.out.print(isMatch("mississippi","mis*is*p*."));
	 }
}
