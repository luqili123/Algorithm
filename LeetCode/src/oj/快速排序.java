package oj;

import java.util.Scanner;

public class 快速排序 {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		while(scanner.hasNext()){
			String[] temp=scanner.nextLine().split(" ");
			int[] array=new int[temp.length-1];
			for(int i=1;i<temp.length;i++){
				array[i-1]=Integer.parseInt(temp[i]);
			}
			//---------------------------------------------------------
			quickSort(array, 0, array.length-1);
			
			for (int i = 0; i < array.length; i++) {
				if(i==array.length-1)
					System.out.println(array[i]);
				else {
					System.out.print(array[i]+" ");
				}
				
			}
	
		}
	}
	
	// 原始版本
	public static int partiyion_1(int[] arr, int L, int R) {
		int p = arr[R];// 枢轴
		int less = L - 1;// 小于等于区的右边界

		for (int i = L; i <= R; i++) {
			// 如果i上的元素小于等于枢轴，则小于区增大1，
			// 如果i上的元素大于枢轴，则直接跳过
			if (arr[i] <= p) {
				++less;
				int temp = arr[less];
				arr[less] = arr[i];
				arr[i] = temp;
			}

		}

		return less;
	}
	
	
	
	//改进版本
	public static int[] partiyion(int[] arr,int L,int R){
		int less=L-1;//小于等于区
		int more=R;//大于区包含枢轴
		while(L<more){
			//L指向的值小于书步骤，小于等于区扩大一个，下标L向后移动一个
			if(arr[L]<arr[R]){
				swap(arr, ++less, L++);
			}else if (arr[L]>arr[R]) {//L指向的值大于枢轴，大于区的前一个数与当前位置上的值交换，大于区扩大一个，下标不变
				swap(arr, --more, L);
			}else {//L指向的位置等于枢轴，直接跳过，大于和小于等于区不变
				L++;
			}
		}
		//最后将枢轴与大于区最左边位置的元素交换
		swap(arr, more, R);
		return new int[]{less+1,more};
		
	}
	
	//随机快速排序
	public static void quickSort(int[] arr,int L,int R){
		//结束条件
		if(L<R){
			swap(arr, L+(int)((Math.random()*(R-L+1))), R);//随机选择一个位置作为枢轴,并将其放到最后一个位置上
			int[] p=partiyion(arr, L, R);//获取小于区和大于区的位置
			quickSort(arr, L, p[0]-1);//再对更小的区域做相同排序操作
			quickSort(arr, p[1]+1, R);
		}
	}
	
	private static void swap(int[] arr,int a,int b){
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}

}
