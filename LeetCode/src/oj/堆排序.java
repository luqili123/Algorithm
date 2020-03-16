package oj;

public class 堆排序 {
	/**
	 * 将数组中index位置上的元素调整至堆中正确的位置
	 * @param array
	 * @param index
	 */
	public static void heapInsert(int[] array,int index){
		while(array[index]>array[(index-1)/2]){
			swap(array, index, (index-1)/2);
			index=(index-1)/2;
		}
	}
	
	/**
	 * 与index节点左右孩子比较，找出父节点，左右孩子中的最大值，孩子大的话，交换之后，继续和新位置的节点的左右孩子比较，直到不需要交换停止
	 * @param array
	 * @param index
	 * @param heapsize 堆的大小
	 */
	public static void heapify(int[] array,int index,int heapsize){
		int left=index*2+1;//某节点的左孩子下标
		while(left<heapsize){
			int largest=(left+1<heapsize&&array[left+1]>array[left]) ? left+1 : left;//该节点存在右孩子且有孩子大于左孩子？右孩子下标:左孩子下标
			largest=array[largest]>array[index]?largest:index;//左右孩子中较大的和父节点比较，谁大选谁
			if(largest==index){
				break;//父节点是最大的，则跳出循环
			}
			swap(array, largest, index);//父节点和孩子中较大的交换
			index=largest;
			left=index*2+1;
		}
	}
	
	public static void heapSort(int[] arr) {
		if(arr==null||arr.length<2)
			return ;
		//将数组中的元素一次放入堆中并调整到正确的位置（大根堆）
		for(int i=0;i<arr.length;i++){
			heapInsert(arr, i);
		}
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		int heapsize=arr.length;
		swap(arr, 0, --heapsize);//将根节点和数组最后一个元素交换，堆大小减一
		while(heapsize>0){
			heapify(arr, 0, heapsize);
			swap(arr, 0, --heapsize);
		}
	}
	
	/**
	 * 交换
	 * @param arr
	 * @param a
	 * @param b
	 */
	private static void swap(int[] arr,int a,int b){
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
	
	public static void main(String[] args) {
		int[] array={2,7,4,1,9,2,123,213,3,1,12,4,4,4};
		heapSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
			
		}
	}
}
