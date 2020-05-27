package sort;
//递归思想，选一个关键字最为枢轴，第一趟划分将比枢轴小的放到其左边，大的放到右边，接着分别对左右两边做上面相同的操作


public class QuickSort {
	public void quickSort(int R[],int low,int high){
		int i=low,j=high;
		int temp;
		if(low<high){
			temp=R[low];
			while(i<j){
				while (j>i&&R[j]>temp) j--;
				if(i<j){
					R[i]=R[j];
					i++;
				}
				while(i<j&&R[i]<temp) i++;
				if(i<j){
					R[j]=R[i];
					j--;
				
			}
		}
			R[i]=temp;
			quickSort(R,low,i-1);
			quickSort(R, i+1, high);
	}
}
}
