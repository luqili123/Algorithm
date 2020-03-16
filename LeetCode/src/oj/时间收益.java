package oj;
import java.util.Scanner;
public class 时间收益 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		while(t-->0){
			int n=scanner.nextInt();
			int[] id=new int[n];
			int[] deadline=new int[n];
			int[] profit=new int[n];
			
			for(int i=0;i<n;i++){
				id[i]=scanner.nextInt()-1;
				deadline[i]=scanner.nextInt();
				profit[i]=scanner.nextInt();
			}
			for(int i=0;i<n;i++){
				for(int j=0;j<n-1;j++){
					if(profit[j]<profit[j+1]){
						swap(profit, j, j+1);
						swap(deadline, j+1, j);
						swap(id, j+1, j);
					}
				}
			}
//			for(int i=0;i<n;i++){
//				System.out.print(id[i]+" ");
//				System.out.print(deadline[i]+" ");
//				System.out.print(profit[i]+" ");
//			}
//			System.out.println();
			int total=0;
			int count=0;
			for(int i=0;i<n;i++){
				if(deadline[i]>0){
					total+=profit[i];
					count++;
					for(int j=0;j<n;j++){
						deadline[j]=deadline[j]-1;
						
					}
				}
			}
			
			System.out.println(count+" "+total);
		}
	}
	public static void swap(int[] arr,int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
