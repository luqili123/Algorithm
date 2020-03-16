package oj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 *
1
4 a
a b c d
a 0 1 1 0
b 1 0 1 0
c 1 1 0 1
d 0 0 1 0
 * 
 */

public class 广度优先遍历 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=Integer.parseInt(scanner.nextLine());
		for(int p=0;p<n;p++){
			String temp=scanner.nextLine();
			int len=temp.charAt(0)-'0';
			String start=temp.charAt(2)+"";
			String[] element=scanner.nextLine().split(" ");
			
			String[][] matrix=new String[len][len];
			for(int i=0;i<len;i++){
				matrix[i]=scanner.nextLine().substring(2).split(" ");
			}
			//-----------------------------------------------------------------------
			traverse(new ArrayList<String>(), matrix, element);
		}
	}
	public static void traverse(ArrayList<String> arrayList,String[][] matrix,String[] element) {
		HashMap<String , Integer> hashMap=new HashMap<String, Integer>();
		for(int i=0;i<element.length;i++){
			hashMap.put(element[i], i);
		}
		Queue<String> queue=new LinkedList<String>();
		queue.add(element[0]);
		arrayList.add(element[0]);
		while(!queue.isEmpty()){
			String str=queue.poll();
			for(int i=0;i<element.length;i++){
				int row=hashMap.get(str);
				if((!arrayList.contains(element[i]))&&matrix[row][i].equals("1")){
					queue.add(element[i]);
					arrayList.add(element[i]);
				}
			}		
		}
		int count=1;
		for (Iterator iterator = arrayList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			
			if(count==arrayList.size()){
				System.out.println(string);
			}else {
				System.out.print(string+" ");
			}
			count++;
		}
		
	}
}
