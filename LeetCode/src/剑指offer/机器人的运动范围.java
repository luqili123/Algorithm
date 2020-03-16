package 剑指offer;
/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子?
 * 
 * 深度优先遍历
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * @author lqllq
 *
 */
public class 机器人的运动范围 {
	public static int movingCount(int m, int n, int k) {		
		if(m<0||n<0){
			return 0;
		}
		int[][] visited=new int[m][n];
		return move(visited,0,0,k);
		
    }
	public static int move(int[][] visited,int x,int y,int k){
		if(x<0||y<0||x>=visited.length||y>=visited[0].length||visited[x][y]==1){
			return 0;
		}
		//检查该位置是否可以走
		if(!check(x,y,k)){
			return 0;
		}else{
			visited[x][y]=1;
			return move(visited,x-1,y,k)+move(visited,x+1,y,k)+move(visited,x,y-1,k)+move(visited,x,y+1,k)+1;
		}
	}
	
	public static boolean check(int x,int y,int k){
		int sumx=0;
		int sumy=0;
		while(x!=0){
			sumx+=x%10;
			x/=10;
		}
		while(y!=0){
			sumy+=y%10;
			y/=10;
		}
		return sumx+sumy<=k;
	}
	public static void main(String[] args){
		System.out.println(movingCount(38,15,9));
		
	}
	
	
}
