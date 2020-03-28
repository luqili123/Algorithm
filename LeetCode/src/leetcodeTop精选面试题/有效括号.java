package leetcodeTop精选面试题;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
	有效字符串需满足：	
	左括号必须用相同类型的右括号闭合。
	左括号必须以正确的顺序闭合。
	注意空字符串可被认为是有效字符串。
 * @author lqllq
 * 
 *
 */
public class 有效括号 {
	public boolean isValid(String s) {
		if(s.equals("")){
			return true;
		}
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<s.length();i++){
			char t=s.charAt(i);
			if(t=='('||t=='{'||t=='['){
				stack.push(t);
			}else if(t==')'){
				if(!stack.isEmpty()&&'('==stack.peek()){
					stack.pop();
				}else{
					return false;
				}
			}else if(t=='}'){
				if(!stack.isEmpty()&&'{'==stack.peek()){
					stack.pop();
				}else{
					return false;
				}
			}else if(t==']'){
				if(!stack.isEmpty()&&'['==stack.peek()){
					stack.pop();
				}else{
					return false;
				}
			}
			
		}
		return stack.isEmpty();
    }
}
