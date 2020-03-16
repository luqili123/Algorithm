package list;

import java.util.Stack;

public class TwoStack {
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
    	// 现将stack2中元素返还到stack1中
       while(!stack2.isEmpty()){
    	   stack1.push(stack2.pop());
       }
       //然后再对stack1压栈
       stack1.push(node);
    }
    
    public int pop() {
    	//现将stack1中的数据全部移到stack2再进行出站
    	while(!stack1.isEmpty()){
    		stack2.push(stack1.pop());
    	}
    	return stack2.pop();
    }
}
