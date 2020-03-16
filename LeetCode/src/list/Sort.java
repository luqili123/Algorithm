package list;

import java.util.Arrays;
import java.util.Scanner;



public class Sort {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int row=scanner.nextInt();
		
		for(int i=0;i<row;i++){
			int count=scanner.nextInt();
			int[] array=new int[count];
			int[] result=new int[count];
			//获取数据
			for(int x=0;x<count;x++){
				array[x]=scanner.nextInt();
				result[x]=array[x];
			}
			//对数据排序
			int time=0;
			Arrays.sort(result);
			for(int y=0;y<array.length;y++){
				if(array[y]!=result[y]){
					for(int z=y;z<array.length;z++){
						if(array[z]==result[y]){
							int temp=array[y];
							array[y]=array[z];
							array[z]=temp;
							time++;
						}
					}
				}
			}
//			for(int num : array)
//				System.out.println(num+" ");
			System.out.println(time);
			
		}
	}
}
