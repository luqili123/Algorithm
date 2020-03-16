package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
public class GeiDingShuZuPaiXv {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int row=scanner.nextInt();
		
		for(int i=0;i<row;i++){
			//A1数组元素个数
			int num1=scanner.nextInt();
			////A2数组元素个数
			int num2=scanner.nextInt();
			int[] array1=new int[num1];
			int[] array2=new int[num2];
			for(int m=0;m<num1;m++){
				array1[m]=scanner.nextInt();
			}
			for(int n=0;n<num2;n++){
				array2[n]=scanner.nextInt();
			}
			HashMap<Integer, Integer> hashMap=new HashMap<Integer, Integer>();
			ArrayList<Integer> aList=new ArrayList<Integer>();
			for(int x=0;x<num2;x++){
				for(int y=0;y<num1;y++){
					//将两个数组中重复的数字存入arraylist中
					//hashmap记录出现次数
					if(array1[y]==array2[x]){
						if(hashMap.containsKey(array1[y]))
							hashMap.put(array1[y], hashMap.get(array1[y])+1);
						else {
							hashMap.put(array1[y], 1);
							aList.add(array1[y]);
						}
					}
				}
			}
			int time=0;
			for(int p=0;p<aList.size();p++){
				int temp=aList.get(p);
				for(int q=0;q<hashMap.get(temp);q++){
					time++;
					if(time==array1.length){
						System.out.println(temp);
					}
					else {
						System.out.print(temp+" ");
					}
					
					
				}
			}
			if(time<array1.length){
				int[] temparr=new int[array1.length-time];
				int c=0;
				for(int t=0;t<array1.length;t++){
					if(!hashMap.containsKey(array1[t])){
						temparr[c]=array1[t];
						c++;
					}
				}
				Arrays.sort(temparr);
				for(int b=0;b<temparr.length;b++){
					if(b==temparr.length-1)
						System.out.println(temparr[b]);
					else {
						System.out.print(temparr[b]+" ");
					}
				}
			}
			
//			System.out.println("time="+time+"----len="+array1.length);
		}
	}
}
