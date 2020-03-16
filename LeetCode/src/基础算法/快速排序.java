package 基础算法;

public class 快速排序 {
	
	public static void quicksort(int[] num,int L,int R){
		int temp;
		int i=L;
		int j=R;
		//递归终止条件
		if(L<R){
			temp=num[L];
			//循环内的代码循环一次一次完成一次交换，循环结束后，分割成左右两个区域
			while(i<j){
				//找到第一个小于枢轴的数		
				while(i<j&&num[j]>=temp){
					j--;
				}
				//找到之后，将i的位置替换成这个数（因为枢轴位置的数被保留在temp中，，所以不用担心被覆盖）
				if(i<j){
					num[i]=num[j];
					i++;
				}
				//i开始移动，找到第一个大于枢轴的数
				while(i<j&&num[i]<=temp){
					i++;
				}
				//将这个数移动到j的位置
				if(i<j){
					num[j]=num[i];
					j++;
				}
			}
			//将枢轴的值放到该位置此时i，j在一起，选哪个都一样，
			num[i]=temp;
			//递归
			quicksort(num,L,i-1);
			quicksort(num,i+1,R);
		}
	}

	public static void main(String[] args){
		int[] num={5,2,4,4,5,6,10};
		quicksort(num,0,num.length-1);
		for(int i=0;i<num.length;i++){
			System.out.print(num[i]+" ");
		}
	}
}
