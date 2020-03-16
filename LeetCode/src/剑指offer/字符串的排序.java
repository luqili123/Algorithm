package 剑指offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * @author lqllq
 *	全排列
 *
 *设一组数p = {r1, r2, r3, ... ,rn}, 全排列为perm(p)，pn = p - {rn}。
      因此perm(p) = r1perm(p1), r2perm(p2), r3perm(p3), ... , rnperm(pn)。当n = 1时perm(p} = r1。
 */
public class 字符串的排序 {
	
	private static Set<String> temp=new HashSet<>();
	public static String[] permutation(String s) {
		if(s==null||s.equals("")){
			return null;
		}
		char[] arr=s.trim().toCharArray();
		temp=new HashSet<>();
		perm(arr,0,arr.length-1);
		
		String[] result=new String[temp.size()];
		
		return temp.toArray(new String[temp.size()]);		
    }
	public static void perm(char[] arr,int start,int end){
		if(arr==null||start<0||end>=arr.length){
			throw new RuntimeException("param error");
		}
		if(start==end){			
			temp.add(String.valueOf(arr));	
			return;
		}else{
			for(int i=start;i<=end;i++){
				swap(arr,start,i);
				perm(arr,start+1,end);
				swap(arr,start,i);
			}
		}
	}
	
	public static void swap(char[] arr,int i,int j){
		char temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	private static Set<String> res=new HashSet<>();
	public static String[] permutation2(String s) {
		if(s==null){
			return new String[]{};	
		}
		boolean[] visited=new boolean[s.length()];
		perm2("",s,visited);
		return res.toArray(new String[res.size()]);
		
	}
	public static void perm2(String letter,String s,boolean[] visited){
		if(letter.length()==s.length()){
			res.add(letter);
			return ;
		}else{
			for(int i=0;i<s.length();i++){
				char temp=s.charAt(i);
				if(!visited[i]){
					visited[i]=true;
					perm2(letter+String.valueOf(temp),s,visited);
					visited[i]=false;
				}
					
			}
		}
	}
	
	public static void main(String[] args){
		String[] s=permutation2("abcdefg");
		for(int i=0;i<s.length;i++){
			System.out.print(s[i]+" ");
		}
	}
	
}
