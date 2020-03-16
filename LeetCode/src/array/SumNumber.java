package array;

import java.util.Scanner;

public class SumNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			scanner.nextLine();
			String[] temp1 = scanner.nextLine().split(" ");
			int len = temp1.length;
			int[] array = new int[len];
			for (int x = 0; x < len; x++) {
				array[x] = Integer.parseInt(temp1[x]);
			}
			int target=scanner.nextInt();
			int count=0;
			for(int x=0;x<len-1;x++){
				for(int y=x+1;y<len;y++){
					if(array[x]+array[y]==target)
						count++;
				}
			}
			System.out.println(count);

		}
	}
}
