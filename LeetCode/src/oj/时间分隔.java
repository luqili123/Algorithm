package oj;

import java.util.Scanner;
/**
 * 给定到达火车站的所有列车的到站和出发时间。你的任务是找到火车站所需的最小站台数，这样就不会有火车等车了。
 * 
 * 
1
6 
900  940 950  1100 1500 1800
910 1200 1120 1130 1900 2000
 * 
 * @author lqllq
 *
 */
public class 时间分隔 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		while(t-->0){
			int n=scanner.nextInt();
			int[] arrive=new int[n];
			int[] departure=new int[n];
			for(int i=0;i<n;i++){
				arrive[i]=scanner.nextInt();
			}
			for(int i=0;i<n;i++){
				departure[i]=scanner.nextInt();
			}
			//--------------------------------------------------
			int count=1;
			int max=0;
			for(int i=1;i<n;i++){
				for(int j=1;j<i+1;j++){
					if(arrive[i]<=departure[j-1]){
						count++;						
					}
				}
				if(count>max){
					max=count;
				}
				count=1;
			}
			System.out.println(max);
			
		}
	}
}
