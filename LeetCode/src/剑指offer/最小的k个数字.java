package 剑指offer;

import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * @author lqllq
 *	用前K个数建一个大顶堆，即堆顶的那个数是这个堆中最大的数。继续遍历arr数组后面的数，如果数比堆顶的数小，
 *	那么将堆顶的数换成这个更小的数，维护这个堆(heapify函数实现维护功能)。
 */
public class 最小的k个数字 {
	public static int[] getLeastNumbers(int[] arr, int k) {
		if(k==0){
			return new int[]{};
		}
		if(arr.length==k){
			return arr;
		}
		int[] heap=new int[k];
		
		for(int i=0;i<k;i++){
			heap[i]=arr[i];
		}
		//构建堆
		buildHeap(heap);
//		for (int i = 0; i < heap.length; i++) {
//			System.out.print(heap[i]+" ");
//		}
//		System.out.println();
		//将后续的元素与堆顶元素比较，若比堆顶小，则替换对顶元素并调整堆
		for(int i=k;i<arr.length;i++){
			if(arr[i]<heap[0]){
				heap[0]=arr[i];
				adjust(heap);
			}
		}
		Arrays.sort(heap);
		return heap;
		
    }
	
	public static void buildHeap(int[] heap){
		for(int index=0;index<heap.length;index++){
			while(heap[index]>heap[(index-1)/2]){
				swap(heap,index,(index-1)/2);
				index=(index-1)/2;
			}
		}
	}
	
	public static  void adjust(int[] heap){
		int index=0;
		int left=index*2+1;
		while(left<heap.length){
			int right=left+1;
			int lagest=right<heap.length&&heap[right]>heap[left]?right:left;
			lagest=heap[lagest]>heap[index]?lagest:index;
			if(lagest==index){
				break;
			}
			swap(heap,index,lagest);
			index=lagest;
			left=index*2+1;		
		}
	}
	public static void swap(int[] arr,int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void main(String[] args){
		int[] nums={0,1,1,1,4,5,3,7,7,8,10,2,7,8,0,5,2,16,12,1,19,15,5,18,2,2,22,15,8,22,17,6
				,22,6,22,26,32,8,10,11,2,26,9,12,9,7,28,33,20,7,2,17,44,3,52,27,2,23,19,56,56
				,58,36,31,1,19,19,6,65,49,27,63,29,1,69,47,56,61,40,43,10,71,60,66,42,44,10,12
				,83,69,73,2,65,93,92,47,35,39,13,75,75};
		int[] res=getLeastNumbers(nums,75);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]+" ");
		}

		
	}
}
