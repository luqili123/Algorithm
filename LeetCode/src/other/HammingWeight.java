package other;

import java.util.ArrayList;
import java.util.List;


public class HammingWeight {
	public int hammingWeight(int n) {
		//这种方法无法计算负数的1个个数
		int count=0;
//		List<Integer> list=new ArrayList<Integer>();
		
//		while(n>0){
//			list.add(n%2);
//			n=n/2;
//		}
//		for (Integer a : list) {
//			if(a==1) count++;
//		}
//		return count;
		
		
		
		//通过右移操作，每右移一位就通过与1按位与来判断最后一位是否为1。
		//负数右移高位补1，正数右移高位补0，所以这个题目不能用右移做，因为负数右移有无数个0
		//正负数左移低位都是补0的，可以用来计算1的个数，这就要求与n相与的数要不断左移，要与n每一位比较
		int tag=1;
		while(tag!=0){
			if((n&tag)!=0) 
				count++;
			
				tag<<=1;;
			
		}
		return count;

	}
	public static void main(String[] args) {
		HammingWeight hWeight=new HammingWeight();
		System.out.println(hWeight.hammingWeight(-3));
	}
}
