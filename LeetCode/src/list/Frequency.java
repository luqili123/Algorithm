package list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class Frequency {
	
	public static void main(String[] args) {
		Scanner scaner=new Scanner(System.in);
		int row=scaner.nextInt();
		for(int y=0;y<row;y++){
		int number=scaner.nextInt();
		if(number==0)
			return ;
		int[] array=new int[number];
		for(int q=0;q<number;q++){
			array[q]=scaner.nextInt();		
		}	
		HashMap< Integer, Integer>hashMap=new HashMap<Integer, Integer>();
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		for(int p=0;p<number;p++){
			if(hashMap.containsKey(array[p]))
				hashMap.put(array[p], hashMap.get(array[p])+1);
			else {
				hashMap.put(array[p], 1);
				arrayList.add(array[p]);
			}
		}
	
		while(arrayList.size()>0){
		//找到最大值
		int max=0,index=0;
		for(int i=0;i<arrayList.size();i++){
			int n=hashMap.get(arrayList.get(i));			
			if(n>=max){
				if(n==max){
					if(arrayList.get(index)<arrayList.get(i)){
						continue;
					}
				}
				max=n;
				index=i;
			}			
			
		}
//		System.out.println("---"+max+"---"+index+"---ARRAY"+arrayList.size());
		int temp=arrayList.get(index);
		for(int z=0;z<max;z++){
			if(z==max-1&&arrayList.size()==1){
				System.out.print(temp);
				System.out.println();
			}
			else
				System.out.print(temp+" ");
		}
		
		hashMap.remove(arrayList.get(index));
		arrayList.remove(index);
		}
		
			
	}
		
}
}
