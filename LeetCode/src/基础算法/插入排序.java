package 基础算法;
/**
 * 每一趟，将一个待排序的的关键字按照其值的大小插入到已经排好的部分有序序列的适当位置
 * @author lqllq
 *
 */
public class 插入排序 {
	 static void InsertSort(int[] arr){
		int temp;
		int j;
		//选择第二个数字，因为只看第一个数字，这个数字一定是有序的
		for(int i=1;i<arr.length;i++){
			temp=arr[i];
			//指向前一个数字
			j=i-1;
			//依次和前面的数比较
			while(j>=0&&temp<arr[j]){
				//temp比前一个数小，则前一个数后移
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=temp;
		}
	}
	public static void main(String[] args){
		int[] arr={3,43,3,1,4,33,4,131,31,3,244};
		InsertSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
