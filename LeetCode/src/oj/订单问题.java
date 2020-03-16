package oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.text.Position.Bias;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

import jdk.nashorn.internal.objects.NativeRangeError;

public class 订单问题 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int tc = scanner.nextInt();
		while (tc-- > 0) {
			int N = scanner.nextInt();
			int X = scanner.nextInt();
			int Y = scanner.nextInt();

			int A[] = new int[N];
			int B[] = new int[N];

			for (int i = 0; i < N; i++)
				A[i] = scanner.nextInt();
			for (int i = 0; i < N; i++)
				B[i] = scanner.nextInt();
			// -------------------------------------------------
			

			int[] differ = new int[N];
			int[] pos = new int[N];
			for (int i = 0; i < N; i++) {
				differ[i] = Math.abs(A[i] - B[i]);
				pos[i] = i;
			}
			sort(differ, pos);
			int x=X,y=Y;
			int count=0;
			int sum=0;
			for(int i=0;i<N;i++){
				if(x>0&&y>0){					
					if(A[pos[i]]>B[pos[i]]){
						x--;
						sum+=A[pos[i]];
					}else {
						y--;
						sum+=B[pos[i]];
					}
					count++;
				}else {
					break;
				}
			}
			while(count<N){
				if(x>0){
					sum+=A[count-1];
					count++;
				}else if (y>0) {
					sum+=B[count-1];
					count++;
				}					
			}
			System.out.println(sum);
		}
	}

	public static void sort(int[] differ, int[] pos) {
		for (int i = 0; i < differ.length; i++) {
			for (int j = 0; j < differ.length - 1; j++) {
				if (differ[j] < differ[j + 1]) {
					int temp = differ[j];
					differ[j] = differ[j + 1];
					differ[j + 1] = temp;
					
					temp = pos[j];
					pos[j] = pos[j + 1];
					pos[j + 1] = temp;
					
				}
			}
		}
		

	}
	

}
