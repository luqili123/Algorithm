package leetcodeTop精选面试题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @author lqllq
 * 思路：递归，可以将号码构造成一颗树每个数字都有对应的选择，递归得将可能的情况加入到字符串之中
 */
public class 电话号码的字母组合 {
	
	private static List<String> res;
	//2-9位置对应的字符
	private static String[] letterMap={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public static List<String> letterCombinations(String digits) {
		res=new ArrayList<>();
		if(digits.equals("")){
			return res;
		}
		combine(digits,0,new StringBuilder(""));
		return res;
		
    }
	public static void combine(String digits,int index,StringBuilder letter){
		if(index>=digits.length()){
			res.add(letter.toString());
			return;
		}
		int num=digits.charAt(index)-48;
		String str=letterMap[num];
		for(int i=0;i<str.length();i++){
			//将数字对应的字符全部遍历一遍
			combine(digits,index+1,letter.append(str.charAt(i)));
			//递归完之后把自己删掉，否则letter会变得很长
			letter.deleteCharAt(letter.length()-1);
		}
		
	}
	public static void main(String[] args){
		System.out.println(letterCombinations("23").toString());
	}
}
