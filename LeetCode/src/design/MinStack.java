package design;

import java.util.Stack;

//https://blog.csdn.net/alps1992/article/details/41741811
public class MinStack {
	/** initialize your data structure here. */
	private Stack<Long> stack;
	private long min=0;
	
	
    public MinStack() {
       stack =new Stack<Long>();     
       
    }
    
    public void push(long x) {
        if(stack.empty()){
        	stack.push((long) 0);//x-x
        	min=x;
        }else {
			stack.push(x-min);
			if(x<min) min=x;
		}
    }
    
    public void pop() {
        if(stack.empty())
        	return ;
        else {//下面括号里可以提出一个pop，这样写是为了便于理解
			if(stack.peek()>=0)
				 stack.pop();
			else {
				min=min-stack.peek();
				stack.pop();
			}
		}
    }
    
    public long top() {
        if(stack.empty())
        	return (Integer) null;
        else {
			if(stack.peek()>=0)
				return stack.peek()+min;
			else {
				return min;
			}
		}
    }
    
    public long getMin() {
        if(stack.empty())
        	return (Integer) null;
        else {
			return min;
		}
    }
    public static void main(String[] args) {
		MinStack minStack=new MinStack();
		minStack.push(2147483647);
		minStack.push(-2147483648);
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
		
	
	}
}
