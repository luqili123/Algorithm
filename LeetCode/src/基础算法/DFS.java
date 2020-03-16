package 基础算法;

import java.util.Stack;

public class DFS {
	
	/**
	 * 递归解法
	 * @param arr 顶点数组
	 * @param arcs 邻接矩阵
	 * @param index 开始遍历的顶点下标
	 */
	public static void dfs(char[] arr,int[][] arcs,int index ){
		if(arr==null||arr.length==0||index>arr.length-1||arcs==null||arcs.length==0||arcs.length!=arr.length){
			throw new RuntimeException("参数异常！");
		}	
		boolean[] visited=new boolean[arr.length];
		//这层循环是为了遍历从顶点无法到达 的顶点
		for(int i=0;i<arr.length;i++){
			if(visited[i]==false){
				traverse(arr,arcs,i,visited);
			}
		}		
		
	}
	public static void traverse(char[] arr,int[][] arcs,int index,boolean[] visited){
		if(visited[index]==true){
			return;
		}
		//这个节点没有被访问，先遍历这个节点
		visited[index]=true;
		System.out.print(arr[index]);
		
		for(int i=0;i<arr.length;i++){
			//若当前节点可以到达下标为i的节点，且这个节点未被访问，则继续向下遍历
			if(arcs[index][i]==1&&visited[i]==false){
				traverse(arr,arcs,i,visited);
			}
		}
		
	}
	
	/**
	 * 非递归写法
	 * @param arr
	 * @param arcs
	 * @param index
	 */
	public static void dfs2(char[] arr,int[][] arcs,int index ){
		if(arr==null||arr.length==0||index>arr.length-1||arcs==null||arcs.length==0||arcs.length!=arr.length){
			throw new RuntimeException("参数异常！");
		}	
		boolean[] visited=new boolean[arr.length];
		for(int i=0;i<arr.length;i++){
			traverse2(arr,arcs,i,visited);
		}
	}
	
	public static void traverse2(char[] arr,int[][] arcs,int index,boolean[] visited){
		if(visited[index]==true){
			return;
		}
		//这里放入栈的是数组下标
		Stack<Integer> s=new Stack<Integer>();
		visited[index]=true;
		s.push(index);		
		while(!s.isEmpty()){
			//这里要改变index
			index=s.pop();			
			System.out.print(arr[index]);
			for(int i=0;i<arr.length;i++){			
				if(arcs[index][i]==1&&visited[i]==false){
					visited[i]=true;
					s.push(i);
				}
			}
		}
		
	}
	
	public static void main(String[] args){
		char[] arr={'a','b','c','d','e'};
		int[][] arcs={{0,1,0,0,0},
					  {0,0,0,1,0},
					  {0,0,0,1,0},
					  {1,0,0,0,1},
					  {0,0,0,0,0}};
		
		dfs(arr,arcs,0);
		System.out.println();
		dfs2(arr,arcs,0);
		
	}
}
