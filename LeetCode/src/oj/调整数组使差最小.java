package oj;



import java.util.Scanner;

public class 调整数组使差最小 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int k=Integer.parseInt(scanner.nextLine());
		for(int p=0;p<k;p++){
			String[] temp1=scanner.nextLine().split(" ");
			String[] temp2=scanner.nextLine().split(" ");
			int len=temp1.length;			
			int[] array=new int[len*2];
			for(int i=0;i<len;i++){
				array[i]=Integer.parseInt(temp1[i]);
			}
			for(int i=len;i<len*2;i++){
				array[i]=Integer.parseInt(temp2[i-len]);
			}
			//可以将题目转化为长度为2N的数组中挑选N个元素，是这N个元素和尽量解决2N个元素/2
			System.out.println(MinSum(array));
		
		}
		
	}
	public static int MinSum(int[] array){
		int len=array.length;
		int sum=0;
		//计算数组所有元素的和
		for(int i=0;i<len;i++){
			sum+=array[i];
		}
//		System.out.println("sum="+sum);
		//代表flag[i][j]为true代表i个元素的和为j
		boolean[][] flag=new boolean[len][sum/2+1];
		//初始化数组
		for(int i=0;i<len;i++){
			for(int j=0;j<sum/2+1;j++){
				flag[i][j]=false;
			}
		}
		 flag[0][0] = true;
	        for (int k = 0; k < len; k++) {
	            for (int i = k > len/2 ? len/2 : k; i >= 1; i--) {   
	                for (int j = 0; j <= sum / 2; j++) {                    
	                    if (j >= array[k] && flag[i - 1][j - array[k]])
	                        flag[i][j] = true;
	                }
	            }
	        }
		int min=Integer.MAX_VALUE;
		for(int j=0;j<=sum/2;j++){
			if(flag[len/2][j]==true){
				System.out.println(j);
				int result=Math.abs(sum-j*2);
				if(min>result)
					min=result;
			}
		}
		return min;
	}
}
