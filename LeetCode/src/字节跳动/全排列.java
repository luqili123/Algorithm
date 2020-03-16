package 字节跳动;

public class 全排列 {
	public static void perm(int[] arr,int start,int end){
		if(start==end){
			for(int i=0;i<arr.length;i++){
				System.out.print(arr[i]);
			}
			System.out.println();

		}else{
			for(int i=start;i<=end;i++){
				swap(arr,start,i);
				perm(arr,start+1,end);
				swap(arr,start,i);
			}

		}
	}
	
	public static void swap(int[] arr,int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void main(String[] args) {
		int list[]={1,2,3};
        perm(list,0,2);
	}
}
