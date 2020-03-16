package 基础算法;

public class 堆排序 {
	
	public static void buildHeap(int[] arr){
		for(int index=0;index<arr.length;index++){
			while(arr[index]>arr[(index-1)/2]){
				//若当前位置节点比其父节点大，就和父节点交换，这里不用考虑左右子树，因为所有的节点都会变遍历到
				swap(arr,index,(index-1)/2);
				//交换之后在继续看上层
				index=(index-1)/2;
			}
		}
	}
	
	
	public static void adjustHeap(int[] arr,int index,int len){
		//从上往下将树再次调整为大顶堆	
		//每次都是从0位置开始调整
		int left=index*2+1;
		//比较根节点与左右子树，找出最大的节点。
		//若根节点不是最大的，则会被换到下一层，此时为了保证大根堆性质，还要检测交换到下一层之后，下一层的子树是否满足大根堆，不满足继续调整
		while(left<len){			
			int right=left+1;
			//这里是len，不是arr.length
			int lagest=(right<len&&arr[left]<arr[right])?right:left;
			lagest=arr[lagest]>arr[index]?lagest:index;
			//发现最大值就是自己，此时，不需要再调整，自己就是最大值
			if(lagest==index){
				break;
			}
			swap(arr,lagest,index);
			index=lagest;
			left=index*2+1;
		}
		
	}
	public static void heapsort(int[] arr){
		
		buildHeap(arr);
		//交换第一个和最后一个元素
		swap(arr,0,arr.length-1);
		
		for(int i=arr.length-1;i>0;i--){
			adjustHeap(arr,0,i);
			swap(arr,0,i-1);
		}
		
	}
	public static void swap(int[] arr,int i,int j){
		
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void main(String[] args){
		int[] arr={8,3,1,2,3,6,10};
		heapsort(arr);
		
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		
	}
}
