package leetcodeTop精选面试题;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
	例如，给出 n = 3，生成结果为：
	[
	  "((()))",
	  "(()())",
	  "(())()",
	  "()(())",
	  "()()()"
	]

 * @author lqllq
 * 思路：递归，并限制左右括号出现的次数,注意点为要让左括号在有括号前面，否则括号无效
 *
 */
public class 括号生成 {
	private static List<String> res;
	public static List<String> generateParenthesis(int n) {	 
		res=new ArrayList<>();
		if(n<=0){
			return res;
		}
		//左右括号剩余的数量
		int left=n;
		int right=n;
		generate(n,n,new StringBuilder(""));
		return res;
	}
	public static  void generate(int left,int right,StringBuilder s){
		//最终条件
		if(left==0&&right==0){
			res.add(s.toString());
			return;
		}else if(left>0&&left==right){//左右括号剩余数量相同，只能先给左括号
			generate(left-1,right,s.append("("));
			s.deleteCharAt(s.length()-1);
		}else if(left>0&&left<right){//右括号剩的多，左右都可以
			generate(left-1,right,s.append("("));
			s.deleteCharAt(s.length()-1);
			generate(left,right-1,s.append(")"));
			s.deleteCharAt(s.length()-1);
		}else if(left==0&&right>left){//左括号用完了，只能给右括号
			generate(left,right-1,s.append(")"));
			s.deleteCharAt(s.length()-1);
		}

	}
	public static void main(String[] args){
		System.out.print(generateParenthesis(4).toString());
	}
}
