package oj;

import java.util.Scanner;

/**
 * 有一个由N个实数构成的数组，如果一对元素A[i]和A[j]是倒序的，即i<j但是A[i]>A[j]则称它们是一个倒置，设计一个计算该数组中所有倒置数量的算法。
 * 要求算法复杂度为O(nlogn)
 * @author lqllq
 *
 */
public class 倒置个数 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		while(t-->0){
			count=0;
			int len=scanner.nextInt();
			int[] array=new int[len];
			for(int i=0;i<len;i++){
				array[i]=scanner.nextInt();
			}
			//------------------------------------------
			InverseNum(array, 0, array.length-1);
			System.out.println(count);
		}
	}
	public static void InverseNum(int[] array,int l,int r){
		if(l==r){
			return ;
		}else {
			int mid=(l+r)/2;
			InverseNum(array, l, mid);
			InverseNum(array, mid+1, r);
			merage(array, l, mid, r);
		}
	}
	public static int count=0;
	public static void merage(int[] array,int l,int m,int r){
		int p1=l;
		int p2=m+1;
		while(p1<=m){
			p2=m+1;
			while(p2<=r){
				if(array[p1]>array[p2]){
					count++;
				}
				p2++;
			}
			p1++;
		}
		
	}
}
