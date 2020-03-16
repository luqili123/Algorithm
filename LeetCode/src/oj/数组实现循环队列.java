package oj;

public class 数组实现循环队列 {
	
	public static void main(String[] args) {
		
	}
}

class ArrayQueue{
	private Integer[] arr;
	private Integer size;
	private Integer start;
	private Integer end;
	public ArrayQueue(int initSize) {
		if(initSize<0)
			throw new IllegalArgumentException("队列长度小于0");
		arr=new Integer[initSize];
		size=0;
		start=0;
		end=0;		
	}
	public Integer peek() {
		if(size==0)
			return null;
		return arr[start];
	}
	public void push(int value) {
		if(size==arr.length)
			throw new ArrayIndexOutOfBoundsException("Queue is full");
		size++;
		arr[end]=value;
		end=end==arr.length-1?0:end+1;
	}
	public Integer poll() {
		if(size==0)
			throw new ArrayIndexOutOfBoundsException("The queue is empty");
		size--;
		int tmp=start;
		start=start==arr.length-1?0:start+1;
		return arr[tmp];
		
	}
	
}