package sort;

/*  比较array2与array1中最后面的那个元素，把最大的插入第m+n位
	改变数组的索引，再次进行上面的比较，把最大的元素插入到array1中的第m+n-1位。
	循环一直到结束。循环结束条件：当index1或index2有一个小于0时，此时就可以结束循环了。如果index2小于0，说明目的达到了。
	如果index1小于0，就把array2中剩下的前面的元素都复制到array1中去就行。
*/
public class Merge {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i=m-1,j=n-1,k=m+n-1;
		while(i>=0||j>=0){
			if(i<0)
				nums1[k--]=nums2[j--];
			else if (j<0) {
				nums1[k--]=nums1[i--];
			}
			else if (nums1[i]>nums2[j]) {
				nums1[k--]=nums1[i--];
			}
			else  {
				nums1[k--]=nums2[j--];
			}
			
		}
		for (int p : nums1) {
			System.out.print(p);
		}
		
	}

	public static void main(String[] args) {
		Merge merge = new Merge();
		int[] nums1={1,2,3,0,0,0};
		int[] nums2={2,5,6};
		merge.merge(nums1, 3, nums2, 3);
		
	}
}
