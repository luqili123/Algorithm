package 字节跳动;

public class 快速排序 {
	
	public static void quicksort(int[] num,int L,int R){
		int temp=num[L];
		int i=L;
		int j=R;
		if(L<R){
			while(i<j){
				while(i<j&&num[j]>temp){
					j--;
				}
				if(i<j){
					num[i]=num[j];
					i++;
				}
				while(i<j&&num[i]<temp){
					i++;
				}
				if(i<j){
					num[j]=num[i];
					j++;
				}
			}
			num[i]=temp;
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
