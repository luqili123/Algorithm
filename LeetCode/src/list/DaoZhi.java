package list;

import java.util.Scanner;

public class DaoZhi {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int row=scanner.nextInt();
		for(int i=0;i<row;i++){
			int number=scanner.nextInt();
			int[] array=new int[number];
			//获取数据
			for(int n=0;n<number;n++)
				array[n]=scanner.nextInt();
			//强行破解
			int time=0;
			for(int x=0;x<number-1;x++){
				for(int y=x+1;y<number;y++){
					if(array[x]>array[y])
						time++;
				}
			}
			System.out.println(time);
		}
	}
}
