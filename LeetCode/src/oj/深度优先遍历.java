package oj;


import java.util.Scanner;




public class 深度优先遍历 {
	
	private static int maxDepth=Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=Integer.parseInt(scanner.nextLine());
		for(int p=0;p<n;p++){
			String temp=scanner.nextLine();
			int len=temp.charAt(0)-'0';
			String start=temp.charAt(2)+"";
			String[] element=scanner.nextLine().split(" ");
			boolean[] visited=new boolean[element.length];
			for (int i = 0; i < visited.length; i++) {
				visited[i]=false;
			}
			String[][] matrix=new String[len][len];
			for(int i=0;i<len;i++){
				matrix[i]=scanner.nextLine().substring(2).split(" ");
			}
			//-----------------------------------------------------------------------
			for(int i=0;i<len;i++){
				if(visited[i]==false){
					traverse(i,visited,matrix,1);
				}
				
			}
			System.out.println(maxDepth);
		}
	}
	
	
	public static void traverse(int j,boolean[] visited,String[][] matrix,int depth) {
		
		if(depth>maxDepth){
			maxDepth=depth;
		}
		visited[j]=true;
		for(int k=0;k<visited.length;k++){
			if(matrix[j][k].equals("1")&&visited[k]==false){
				traverse(k, visited, matrix,depth+1);
			}
		}
	}
	
}
