package oj;

import java.util.Scanner;



/**
 * 
 *  n a given cartesian plane, there are N points. We need to find the Number of Pairs of points(A,B) such that

	Point A and Point B do not coincide.
	Manhattan Distance and the Euclidean Distance between the points should be equal.
	Note : Pair of 2 points(A,B) is considered same as Pair of 2 points(B,A).

	Manhattan Distance = |x2-x1|+|y2-y1|	

	Euclidean Distance = ((x2-x1)^2 + (y2-y1)^2)^0.5 where points are (x1,y1) and (x2,y2).

	Constraints:1<=T <= 50, 1<=N <= 2*10 ^ 5, 0<=(|Xi|, |Yi|) <= 10^9
 * 
 * 
 * @author lqllq
 *
 */
public class 距离问题 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		while(t-->0){
			int N=scanner.nextInt();
			int x[]=new int[N];
			int y[]=new int[N];
			for(int i=0;i<N;i++){
				x[i]=scanner.nextInt();
				y[i]=scanner.nextInt();
			}
		
			int count=0;
			for(int i=0;i<N;i++){
				for(int j=i+1;j<N;j++){
					if(!(x[i]==x[j]&&y[i]==y[j])){
						if((x[i]==x[j])||(y[i]==y[j])){

							count++;
						}
					}
				}
			}
			System.out.println(count);
		}
	}
}
















