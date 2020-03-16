package oj;



/**
 * 
 * 算法思想：
	1.先将n个元素随便排成一列。

	2.采用swap，将第1个位置的元素分别与后面n-1个位置的元素交换，就可以得到第一个位置元素的不同情况。

	在每种情况下用递归调用得到第2个位置放不同元素的情况，即将第2个位置的元素与余下n-2个位置元素交换。

	在第二个位置放不同元素的情况下，（再次递归调用）将第3个位置与余下n-3个位置元素交换；…………

	4.直到当前位置到第n个位置，表示处理结束。k=n也称递归出口。

 * 
 * @author lqllq
 *
 */
public class N个数的全排列 {
	public static void main(String[] args) {
		int list[]={1,2,3,4};
        perm(list,0,3);
	}

	public static void perm(int list[], int k, int m) {
		if (k == m) {
			for (int i = 0; i <= m; i++)
				System.out.print(list[i]);
			System.out.println();
		} else {
			for (int i = k; i <= m; i++) {
				swap(list, k, i);
				perm(list, k + 1, m);
				swap(list, k, i);
			}
		}
	}

	public static void swap(int[] list, int k, int i) {
		int temp = list[k];
		list[k] = list[i];
		list[i] = temp;
	}

}
