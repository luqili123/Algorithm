package 基础算法;

public class 归并排序 {
	public static void mergeSort(int[] num,int l,int r){
		if(l==r){
			return;
		}else{
			int mid=(l+r)>>1;
			//先划分为子串，并对子串排序
			mergeSort(num,l,mid);
			mergeSort(num,mid+1,r);
			//两个子串排好序之后，在合并到一起
			merge(num,l,mid,r);
		}
	}
	
	public static void merge(int[] num,int l,int m,int r){
		int[] temp=new int[r-l+1];
		int i=l;
		int j=m+1;
		int x=0;
		while(i<=m&&j<=r){
			temp[x++]=num[i]<num[j]?num[i++]:num[j++];
		}
		while(i<=m){
			temp[x++]=num[i++];
		}
		while(j<=r){
			temp[x++]=num[j++];
		}
		for(int k=0;k<temp.length;k++){
			num[k+l]=temp[k];
		}
	}
	public static void main(String[] args){
		int[] num={2,7,4,1,9,2};
		mergeSort(num,0,num.length-1);
		for(int i=0;i<num.length;i++){
			System.out.print(num[i]+" ");
		}
	}
	
	
	
	
	
	
}
