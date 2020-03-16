package oj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given the list of coins of distinct denominations and total amount of money. Output the minimum number of coins required to make up that amount.
 *  Output -1 if that money cannot be made up using given coins. You may assume that there are infinite numbers of coins of each type.
 *  
 *  
 *  The first line contains 'T' denoting the number of test cases. Then follows description of test cases. Each cases begins with the two space separated integers 'n' and 'amount' denoting the total number of distinct coins and total amount of money respectively. The second line contains N space-separated integers A1, A2, ..., AN denoting the values of coins. 

	Constraints:1<=T<=30，1<=n<=100，1<=Ai<=1000，1<=amount<=100000
 * @author lqllq
 *
 */
public class 硬币最小数量 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		while(t-->0){
			int n=scanner.nextInt();
			int amount=scanner.nextInt();
			int[] values=new int[n];
			for(int i=0;i<n;i++){
				values[i]=scanner.nextInt();
			}
			//----------------------------------------------
			Arrays.sort(values);
			int count=0;
			for(int i=values.length-1;i>=0;i--){
				while(amount>=values[i]){
					amount-=values[i];
					count++;
				}
				
			}
			if(amount==0){
				System.out.println(count);
			}else{
				System.out.println(-1);
			}
		}
	}
}
