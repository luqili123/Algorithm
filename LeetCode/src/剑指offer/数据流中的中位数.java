package 剑指offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 设计一个支持以下两种操作的数据结构：
	void addNum(int num) - 从数据流中添加一个整数到数据结构中。
	double findMedian() - 返回目前所有元素的中位数。
 * @author lqllq
 *	思路：大顶堆和小顶堆
 *	1.手写堆排序
 *	2.优先队列
 */
public class 数据流中的中位数 {
	 /** initialize your data structure here. */
	//大顶堆
	PriorityQueue<Integer> big=null;
	//小顶堆
	PriorityQueue<Integer> small=null;
	private int count;
    public 数据流中的中位数() {
    	big=new PriorityQueue<>();
    	small=new PriorityQueue<>(new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO 自动生成的方法存根
				return  (o2-o1);
			}
    		
    	});
    	count=0;
    }
    
    public void addNum(int num) {
    	//偶数，加入大顶堆
    	if(count%2==0){
    		big.offer(num);
    		small.offer(big.poll());
    	}else{
    		small.offer(num);
    		big.offer(small.poll());
    	}
    	count++;
    }
    
    public double findMedian() {
    	
		if(count%2==0){
			return ((double)big.peek()+(double)small.peek())/2;
		}else{
			return (double)small.peek();
		}
    }
    
    
    
    public static void main(String[] args){
    	数据流中的中位数 a=new 数据流中的中位数();
    	
    	a.addNum(1);
    	a.addNum(2);
    	System.out.println(a.findMedian());
    	a.addNum(3);
    	a.addNum(4);
    	System.out.println(a.findMedian());
    	a.addNum(5);
    	a.addNum(1);
    	a.addNum(2);
    	System.out.println(a.findMedian());
    	a.addNum(10);
    	a.addNum(20);
    	a.addNum(5);
    	System.out.println(a.findMedian());
    	a.addNum(9);
    	a.addNum(0);
    	System.out.println(a.findMedian());    	;
    	
    }
}
