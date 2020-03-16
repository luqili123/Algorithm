package array;


import java.util.Scanner;

public class SubArray {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int k=scanner.nextInt();
		for(int i=0;i<k;i++){
			scanner.nextLine();
			String[] temp=scanner.nextLine().split(" ");
			int num=scanner.nextInt();
			int len=temp.length;
			int[] array=new int[len];
			for(int x=0;x<len;x++){
				array[x]=Integer.parseInt(temp[x]);
			}
			int count=0;
			int left=0;
			int right=0;
			while(left<len){
				right=left+1;
				int max=array[left],min=array[left];
				while(right<len){
					if(array[right]>max)
						max=array[right];
					if(array[right]<min)
						min=array[right];
					if(max-min>num)
						count++;
					right++;
				}	
				left++;
			}
			System.out.println(count);
			
		}
	
	}
}
