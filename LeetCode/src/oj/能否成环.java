package oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import com.sun.corba.se.spi.orb.StringPair;
/**
 * 判断字符串数组能否成环
 * 
 * 如果可以成环，则无论从哪一个元素开始找都能够成环
 * @author lqllq
 *
 */
public class 能否成环 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=Integer.parseInt(scanner.nextLine());
		while(t-->0){
			int len=Integer.parseInt(scanner.nextLine());
			String[] array=scanner.nextLine().split(" ");
			if(judge(array)){
				System.out.println("1");
			}else {
				System.out.println("0");
			}
			
			
		}
		
	}
	public static boolean judge(String[] array){
		ArrayList<String> aList=new ArrayList<String>(Arrays.asList(array));
		if(array.length==1){
			if(array[0].charAt(0)==array[0].charAt(array[0].length()-1)){
				return true;
			}
			return false;
		}
		String str1=aList.get(0);
		char start=str1.charAt(0);//起始元素的第一个字符
		char end=str1.charAt(str1.length()-1);//起始元素的最后有一个字符
				
		char c=str1.charAt(0);//起始元素的第一个字符
		aList.remove(0);
		for(int i=0;i<array.length;i++){		
			for(int j=1;j<array.length;j++){
				String temp=array[j];
				if(aList.contains(temp)&&temp.charAt(0)==end){
					start=temp.charAt(0);
					end=temp.charAt(temp.length()-1);
					if(aList.size()==1){
						if(end==c)
							return true;
					}else {
						aList.remove(aList.indexOf(array[j]));
					}
					break;
				}
			}
		}
		return false;
		
		
	}
}




