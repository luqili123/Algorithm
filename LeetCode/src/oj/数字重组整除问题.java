package oj;

import java.util.Scanner;
import javafx.scene.AmbientLight;

/**
 * Babul’s favourite number is 17. He likes the numbers which are divisible by 17. 
 * This time what he does is that he takes a number N and tries to find the largest
 *  number which is divisible by 17, by rearranging the digits. As the number increases 
 *  he gets puzzled with his own task. So you as a programmer have to help him to 
 *  accomplish his task.Note: If the number is not divisible by rearranging the digits,
 *  then print “Not Possible”. N may have leading zeros.
 *  
 *  
 *  
 *  
4
17
43
15
16


17
34
51
Not Possible
 * @author lqllq
 *
 */
public class 数字重组整除问题 {
	static int max=-1;
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		scanner.nextLine();
		while(t-->0){
			char[] c=scanner.nextLine().toCharArray();
			int[] num=new int[c.length];
			for(int i=0;i<c.length;i++){
				num[i]=c[i]-48;
			}
			max=-1;
			perm(num, 0, num.length-1);
			if(max==-1){
				System.out.println("Not Possible");
			}else {
				System.out.println(max);
			}

			
		}
	}
	public static void swap(int[] list ,int i,int j){
		int temp=list[i];
		list[i]=list[j];
		list[j]=temp;
	}
	public static void perm(int[] list,int k,int m){
		if(k==m){
			
			int x=list[0];
			for(int i=1;i<=m;i++){
				x=x*10+list[i];
			}
			if(x%17==0&&x>max&&x>=17){
				max=x;
			}

		}else {
			for(int i=k;i<=m;i++){
				swap(list, k, i);
				perm(list, k+1, m);
				swap(list, k, i);
			}
		}
	}
	
}
