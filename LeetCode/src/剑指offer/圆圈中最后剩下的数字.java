package 剑指offer;

import java.util.LinkedList;
import java.util.List;

/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
	例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * @author lqllq
 * 思路：1.用链表模拟这一过程，空间复杂度高
 */
public class 圆圈中最后剩下的数字 {
	/**
	 * 用链表模拟,时间空间复杂度较高
	 * @param n
	 * @param m
	 * @return
	 */
	public static int lastRemaining(int n, int m) {
		List<Integer> list=new LinkedList<>();
		//初始化
		for(int i=0;i<n;i++){
			list.add(i);
		}
		//删除位置的坐标
		int index=(m-1)%n;
		while(list.size()>1){
//			System.out.println(list.get(index));
			list.remove(index);
			index=(index+m-1)%list.size();
		}
		return list.get(0);
		
    }
	
	/**
	 * 动态规划？？？
	 * @param n
	 * @param m
	 * @return
	 */
	public static int lastRemaining2(int n, int m) {
		 int flag = 0;   
		    for (int i = 2; i <= n; i++) {
		        flag = (flag + m) % i;
		        //动态规划的思想，将f(n,m)替换成flag存储
		    }
		    return flag;
	}
	public static void main(String[] args){
		System.out.print(lastRemaining(10,17));
		
	}
}
