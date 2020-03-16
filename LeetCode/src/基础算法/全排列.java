package 基础算法;

public class 全排列 {
	/**
	 * 递归算法，非去重
	 * @param arr
	 * @param start
	 * @param end
	 */
	public static void perm(int[] arr,int start,int end){
		if(start==end){
			for(int i=0;i<arr.length;i++){
				System.out.print(arr[i]);
			}
			System.out.println();

		}else{
			//循环的作用是让每个元素都可以交换start的位置
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
