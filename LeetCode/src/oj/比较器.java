package oj;

import java.util.Arrays;
import java.util.Comparator;

public class 比较器 {
	private String name;
	private int id;
	private int age;
	  public 比较器(String name,int id,int age) {
		this.name=name;
		this.id=id;
		this.age=age;
	}
	  public static class IdAscendingComparator implements Comparator<比较器>{
	
		@Override
		public int compare(比较器 o1, 比较器 o2) {
			
			return o1.id-o2.id;
		}
		  
	 }
	  
	  public static class IdDescendingComparator implements Comparator<比较器>{
			
			@Override
			public int compare(比较器 o1, 比较器 o2) {
				
				return o2.id-o1.id;
			}
			  
		 }
	  
	  public static void main(String[] args) {
		比较器 s1=new 比较器("A", 1, 23);
		比较器 s2=new 比较器("B", 2, 21);
		比较器 s3=new 比较器("C", 3, 22);
		比较器[] s=new 比较器[]{s1,s2,s3};
		Arrays.sort(s, new IdAscendingComparator());
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i].id);
		}
		  
	}
}
