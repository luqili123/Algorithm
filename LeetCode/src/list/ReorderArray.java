package list;

public class ReorderArray {
	//利用冒泡排序的思想，将偶数移动到右边
	public void reOrderArray(int [] array) {
		int len=array.length;
		int count=0;
        for(int i=len-1;i>=0;i--){
        	if(array[i]%2==0){
        		int temp;
        		for(int j=i;j<len-1-count;j++){
        			temp=array[j];
        			array[j]=array[j+1];
        			array[j+1]=temp;
        		}
        		count++;
        	}
        }
       
    }
	public static void main(String[] args) {
		int[] array={1,2,3,4,5,6,7};
		ReorderArray re=new ReorderArray();
		re.reOrderArray(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
}
