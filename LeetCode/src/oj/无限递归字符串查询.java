package oj;
import java.util.ArrayList;
import java.util.Scanner;
public class 无限递归字符串查询 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		long n = Long.parseLong(scanner.nextLine());
		for(int p=0;p<n;p++){
			System.out.println(find(Long.parseLong(scanner.nextLine())));
		}
	}
//	
//	public static char find(long index) {
//		StringBuilder str=new StringBuilder("12345$54321");
//		int i=2;
//		while(str.length()<index){
//			for(int n=0;n<i;n++){
//				str.append("$");
//			}
//			str.append(str.subSequence(0, str.length()-i));
//			i++;
//			
//			
//		}
//		System.out.println(str);
//		return str.charAt((int) (index-1));
//	}
	public static char find(long pos){
		Long len=(long) 11;
		String str="12345$54321";
		int i=1;
		ArrayList<Long> arrayList=new ArrayList<Long>();
		arrayList.add(len);
		while(len<pos){
			i++;
			len=len*2+i;

			arrayList.add(len);
			
		}

		while(pos>11){
			int index=-1;
			for(int n=0;n<arrayList.size();n++){
				if(pos<=arrayList.get(n)){
					index=n;
					break;
				}				
			}
			pos=pos-arrayList.get(index-1)-index-1;
			if(pos<=0){
				return '$';
			}
			
		}
		return str.charAt((int) pos-1);

		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
