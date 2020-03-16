package 字节跳动;

import java.util.Stack;

public class 栈实现队列 {
	Stack<Integer> s1=new Stack<Integer>();
	Stack<Integer> s2=new Stack<Integer>();
	public void push(Integer value){
		if(value==null){
			throw new RuntimeException("value不能为空");
		}
		s1.push(value);
	}
	public Integer pop(){
		//检查是否为空
		if(s1.size()==0){
			return null;
		}
		while(s1.size()>0){
			s2.push(s1.pop());
		}
		Integer result=s2.pop();
		while(s2.size()>0){
			s1.push(s2.pop());
		}
		return result;
	}
	public static void main(String[] args){
		栈实现队列 queue=new 栈实现队列();
		for(int i=0;i<10;i++){
			queue.push(i);
		}
		for(int i=0;i<5;i++){
			System.out.print(queue.pop()+" ");
		}
	}
}
