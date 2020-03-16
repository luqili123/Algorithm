package 剑指offer;
/**
 * 
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
输入: [7,5,6,4]
输出: 5
 * @author lqllq
 *	思想：归并排序的思想。
 */
public class 数组中的逆序对 {
	public static int reversePairs(int[] nums) {
		if(nums==null||nums.length==0||nums.length==1){
			return 0;
		}
		
		return mergeSort(nums,0,nums.length-1);
    }
	public static int mergeSort(int[] nums,int l,int r){
		if(l==r){
			return 0;
		}
		int m=(l+r)>>1;
		return mergeSort(nums,l,m)+mergeSort(nums,m+1,r)+merge(nums,l,m,r);
	}
	public static int merge(int[] nums,int l,int m,int r){
		
//		for (int i = 0; i < nums.length; i++) {
//			System.out.print(nums[i]+" ");
//		}
		int[] temp=new int[r-l+1];
		int count=0;
		int i=l;
		int j=m+1;
		int index=0;		
		while(i<=m&&j<=r){
			//只比归并排序多了一步，就是在排序的过程中，看左面有几个元素比右面的大。因为已经是排好序的，所以若i位置比右面
			//j位置的元素大，则i到m位置的元素都比j位置元素大，所以直接计算m-i+1.
			count+=nums[i]>nums[j]?(m-i+1):0;
			//易错点：nums[i]<=nums[j]排序时，要不要等号无所谓，但算逆序数的时候，按照我这个思路，等号要加
			temp[index++]=nums[i]<=nums[j]?nums[i++]:nums[j++];
		}
		while(i<=m){
			temp[index++]=nums[i++];
		}
		while(j<=r){
			temp[index++]=nums[j++];
		}
		for(int k=0;k<temp.length;k++){
			nums[k+l]=temp[k];
//			System.out.print(temp[k]+" ");
		}
//		System.out.println("left: "+l+" mid: "+m+" right: "+r+" count: "+count);
		return count;
	}
	public static void main(String[] args){
		int[] nums={1,3,2,3,1};
		System.out.print(reversePairs(nums));
		System.out.println();
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
		
		
	}
}
