package leetcodeTop精选面试题;
/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
	请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
	你可以假设 nums1 和 nums2 不会同时为空。
 * @author lqllq
 *	nums1 = [1, 2]
 	nums2 = [3, 4]
	则中位数是 (2 + 3)/2 = 2.5
 */
public class 寻找两个有序数组的中位数 {
	 /**
	  * 因为有序，所以可以用两个指针移动的方式，移动到中间位置即可.需要注意的是，总长度为偶数时，需要中间两个数的平均值.
	  *时间复杂度为0(M+N)
	  * @param nums1
	  * @param nums2
	  * @return
	  */
	 public static double findMedianSortedArrays(int[] nums1, int[] nums2) {		
		 int len=nums1.length+nums2.length;
		 //如果是偶数，就用他来保存中间位置的前一个数，中位数就是二者之和/2
		 int pre=0;
		 int mid=0;
		 int m=0,n=0;
		 for(int i=0;i<=len/2;i++){
			 pre=mid;
			 if(m<nums1.length&&n<nums2.length){
				 if(nums1[m]<nums2[n]){
					 mid=nums1[m++];
				 }else{
					 mid=nums2[n++];
				 }
			 }else if(m<nums1.length){	 
				mid=nums1[m++];	
			 }else if(n<nums2.length){
				mid=nums2[n++];
			 }		 
		 }
		 if(len%2==0){
			 return (pre+mid)/2.0;
		 }else{
			 return mid;
		 }
	 }
	 public static void main(String[] args){
		 int[] nums1={1,2};
		 int[] nums2={3,4};
		 System.out.print(findMedianSortedArrays(nums1,nums2));
	 }
}
