package 字节跳动;

import java.util.Stack;

public class 包含Max函数的栈 {
	Stack<Integer> s1=new Stack<Integer>();
	Stack<Integer> s2=new Stack<Integer>();
	
	public void push(Integer item){
		if(item==null){
			throw new RuntimeException("不能为空！");
		}
		if(s2.size()==0||s2.peek()<=item){
			s2.push(item);
		}
		s1.push(item);
	}
	public Integer pop(){
		if(s1.size()==0){
			return null;
		}
		if(s1.peek()==s2.peek()){
			s2.pop();
		}
		return s1.pop();
	}
	public Integer max(){
		if(s2.size()==0){
			return null;
		}
		return s2.peek();
	}
	public static void main(String[] args){
		包含Max函数的栈  maxStack=new 包含Max函数的栈();
		maxStack.push(1);
		maxStack.push(10);
		maxStack.push(8);
		maxStack.push(15);
		maxStack.push(6);
		maxStack.push(3);
		maxStack.push(4);
		maxStack.push(1);		
		
		
		for(int i=0;i<8;i++){
			System.out.println(maxStack.max());
			System.out.println(maxStack.pop()+"---");
			
		}
		
	}

}
