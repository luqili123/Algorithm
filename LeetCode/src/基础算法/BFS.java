package 基础算法;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	/**
	 * 非递归解法：广度优先用队列实现，递归是栈，所以，广度优先，不太好用递归写
	 * @param arr 顶点数组
	 * @param arcs 邻接矩阵
	 * @param index 开始遍历的顶点下标
	 */
	public static void bfs(char[] arr,int[][] arcs,int index ){
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
		Queue<Integer> q=new LinkedList<Integer>();
		visited[index]=true;
		q.offer(index);
		
		while(!q.isEmpty()){
			int temp=q.remove();
			System.out.print(arr[temp]+" ");
			for(int i=0;i<arr.length;i++){
				if(arcs[index][i]==1&&visited[i]==false){
					visited[i]=true;
					q.offer(i);
				}
			}
		}
		
		
		
	}
	public static void main(String[] args){
		char[] arr={'a','b','c','d','e'};
		int[][] arcs={{0,1,1,0,0},
					  {0,0,0,1,0},
					  {0,0,0,1,0},
					  {1,0,0,0,1},
					  {0,0,0,0,0}};
		bfs(arr,arcs,0);
	}
}
