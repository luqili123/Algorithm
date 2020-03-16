package 字节跳动;

public class 堆排序 {
	
	public static void buildHeap(int[] arr,int len){
		//构建一个大顶堆
		//从下往上，从右往左的第一个非叶子结点的下标为(arr.length-1)/2
		for(int i=len/2-1;i>=0;i--){
			int left=i*2+1;
			int right=left+1;
			//找出左右子树中较大的数
			int lagest=(right<len&&arr[right]>arr[left])?right:left;
			lagest=arr[lagest]>arr[i]?lagest:i;
			if(lagest!=i){
				swap(arr,lagest,i);
			}
		}
	}
	
	
	public static void adjustHeap(int[] arr,int index,int len){
		int left=index*2+1;
		while(left<len){			
			int right=left+1;
			int lagest=(right<len&&arr[left]<arr[right])?right:left;
			lagest=arr[lagest]>arr[index]?lagest:index;
			if(lagest==index){
				break;
			}
			swap(arr,lagest,index);
			index=lagest;
			left=index*2+1;
		}
		
	}
	public static void heapsort(int[] arr){
		
		buildHeap(arr,arr.length);
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
