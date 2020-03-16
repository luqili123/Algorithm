package 基础算法;

public class 二分查找 {
	public static int binSearch(int arr[], int key) {
		int left=0;
		int right=arr.length-1;
		while(left<=right){
			int mid=left+(right-left)/2;
			if(arr[mid]==key){
				return mid;
			}else if(arr[mid]>key){
				right=mid-1;
			}else{
				left=mid+1;
			}
		}
		return -1;
	}
	public static int binSearch2(int arr[], int key,int start,int end) {
		return -1;
	}
	public static void main(String[] args){
		int[] arr={1,2,3,4,5,6,7};
		System.out.println(binSearch(arr,8));
	}
}
