package 剑指offer;

import java.util.ArrayList;
import java.util.Iterator;

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
public class 数据流中的中位数2 {
	 /** initialize your data structure here. */
	ArrayList<Double> big=null;
	ArrayList<Double> small=null;
	private int count;
    public 数据流中的中位数2() {
    	big=new ArrayList<Double>();
    	small=new ArrayList<Double>();
    	count=0;
    }
    
    public void addNum(int num) {
    		heapInsert(num,count);
    		count++;
    }
    
    public double findMedian() {
		SmallHeapAdjust(small);
		BigHeapAdjust(big);
		//插入的数个数为偶数，则取大顶堆小顶堆根节点平均
    	if(count%2==0){
    		return (big.get(0)+small.get(0))/2;
    	}else{ //为奇数则取小根堆根节点 		 		
    		return small.get(0);
    	}
    }
    
    public void heapInsert(double num,int count){
    	if(count%2==0){
    		//插入数据
    		big.add(num);
    		//调整位置
    		BigHeapAdjust(big);
    		//取出最大值,放入小根堆
    		small.add(big.remove(0)); 
    		

    	}else{
    		small.add(num);
    		SmallHeapAdjust(small);
    		big.add(small.remove(0)); 
    	}
//		SmallHeapAdjust(small);
//		BigHeapAdjust(big);
   	
    	System.out.print("big  ");
    	for (Iterator iterator = big.iterator(); iterator.hasNext();) {
    		Double double1 = (Double) iterator.next();
    		
    		System.out.print(double1+" ");	
		}
    	System.out.println();
    	System.out.print("small ");
      	for (Iterator iterator = small.iterator(); iterator.hasNext();) {
    		Double double1 = (Double) iterator.next();
    		
    		System.out.print(double1+" ");	
		}
      	System.out.println();
    }
    
    public void  BigHeapAdjust(ArrayList<Double> big){
    	
		for(int i=0;i<big.size();i++){
			int index=i;
			while(big.get(index)>big.get((index-1)/2)){
				double temp=big.get(index);
				big.set(index, big.get((index-1)/2));
				big.set((index-1)/2, temp);
				index=(index-1)/2;
			}
		}
    }
    public void  SmallHeapAdjust(ArrayList<Double> small){
    	//调整位置
    	for(int i=0;i<small.size();i++){
    		int index=i;
    		while(small.get(index)<small.get((index-1)/2)){
    			double temp=small.get(index);
    			small.set(index, small.get((index-1)/2));
    			small.set((index-1)/2, temp); 
    			index=(index-1)/2;
    		}
    	}
    }
    
    public static void main(String[] args){
    	数据流中的中位数2 a=new 数据流中的中位数2();
    	
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
