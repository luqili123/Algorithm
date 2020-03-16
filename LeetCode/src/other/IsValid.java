package other;

import java.util.Stack;

public class IsValid {
	public boolean isValid(String s) {
		  if (s.isEmpty())
	            return true;
	        Stack<Character> stack = new Stack<>();
	        for (char c : s.toCharArray()) {
	            if (c == '(')
	                stack.push(')');
	            else if (c == '{')
	                stack.push('}');
	            else if (c == '[')
	                stack.push(']');
	            else if (stack.isEmpty() || stack.pop() != c)
	                return false;
	        }
	        return stack.isEmpty();
	}
		


	public static void main(String[] args) {
		IsValid isValid = new IsValid();
		System.out.println(isValid.isValid("({})"));
	}
}
