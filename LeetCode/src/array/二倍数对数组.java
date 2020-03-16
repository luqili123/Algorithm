package array;

import java.util.Arrays;
import java.util.HashMap;

public class 二倍数对数组 {
	 public static boolean canReorderDoubled(int[] A) {
		 
		 boolean flag=false;
		 for (int i = 0; i < A.length; i++) {
			A[i]=Math.abs(A[i]);
		}
		 Arrays.sort(A);
		 for(int i=0;i<A.length-1;i=i+2){
			 for(int j=i+1;j<A.length;j++){
				 if(2*A[j]==A[i]){
					 swap(A, i, i+1);
					 swap(A, i, j);
					 flag=true;
					 break;
				 }else if (A[j]==2*A[i]) {
					swap(A, i+1, j);
					flag=true;
					break;
				}
			 }
			 if(flag==false){
				 return false;
			 }
			 flag=false;
		 }
		 return true;
	 }
	 
	 
	 public static boolean canReorderDoubled2(int[] A) {
		 HashMap<Integer, Integer> hashMap=new HashMap<Integer, Integer>();
		 for(int i=0;i<A.length;i++){
			 if(A[i]<0){
				 A[i]=-A[i];
			 }

			hashMap.put(A[i], hashMap.getOrDefault(A[i], 0)+1);
		 }
		 
		 return true;
	 }
	 
	 public static void swap(int[] A,int a,int b){
		 int temp=A[a];
		 A[a]=A[b];
		 A[b]=temp;
	 }
	 public static void main(String[] args) {
		int[] A={7,-15,-15,23,-3,80,-35,40,68,22,44,98,20,0,-34,8,40,41,16,46,16,
				49,-6,-11,35,-15,-74,72,-8,60,40,-2,0,-6,34,14,-16,-92,54,14,-68,
				82,-30,50,22,25,16,70,-1,-96,11,45,54,40,92,-35,29,80,46,-30,27,
				7,-70,-37,41,-46,-98,1,-33,-24,-86,-70,80,-43,98,-49,30,0,27,2,82
				,36,0,-48,3,-100,58,32,90,-22,-50,-12,36,6,-3,-66,72,8,49,-30};
		System.out.println(canReorderDoubled(A));
//		for (int i = 0; i < A.length; i++) {
//			System.out.print(A[i]+" ");
//		}
		
	}

}
