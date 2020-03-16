package oj;

import java.util.LinkedList;
import java.util.Queue;

public class 队列实现栈 {

}

class TwoQueuesStack{
	private Queue<Integer> queue;
	private Queue<Integer> help;
	
	public TwoQueuesStack() {
		queue=new LinkedList<Integer>();
		help=new LinkedList<Integer>();
	}
	
	public void push(int value){
		queue.add(value);
	}
	public int peek(){
		if(queue.isEmpty())
			throw new RuntimeException("Stack is empty");
		while(queue.size()!=1){
			help.add(queue.poll());
		}
		int res=queue.poll();
		help.add(res);
		swap();
		return res;
	}
	public int poll(){
		if(queue.isEmpty())
			throw new RuntimeException("Stack is empty");
		while(queue.size()!=1){
			help.add(queue.poll());
		}
		int res=queue.poll();
		swap();
		return res;
	}
	/**
	 * queue和help的引用交换
	 */
	private void swap() {
		Queue<Integer> temp=help;
		help=queue;
		queue=temp;
	}
}