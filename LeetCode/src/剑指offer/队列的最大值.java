package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
        若队列为空，pop_front 和 max_value 需要返回 -1

 * @author lqllq
 * 思路：一个队列存储元素，新增一个双端队列，记录存储在队列中的元素的的最大值
 */
public class 队列的最大值 {
	public static void main(String[] args){
    	
    	MaxQueue mq=new MaxQueue();
    	mq.max_value();
    	
    	
    }
}
class MaxQueue {
	private Queue<Integer> nums=null;
	private LinkedList<Integer> max=null;
    public MaxQueue() {
    	nums=new LinkedList<>();
    	max=new LinkedList<>();
    }
    
    public int max_value() {
    	if(max.size()==0){
    		return -1;
    	}
    	return max.peekFirst();
    	
    }
    
    public void push_back(int value) {
    	//数据加入到nums队列
    	nums.add(value);
    	while(!max.isEmpty()&&max.peekLast()<value){
    		max.pollLast();
    	}
    	max.add(value);
    }
    
    public int pop_front() {
    	if(nums.size()==0){
    		return -1;
    	}
    	int t=nums.poll();
    	if(t==max.peek()){
    		max.poll();
    	}
    	return t;
    }
    
}