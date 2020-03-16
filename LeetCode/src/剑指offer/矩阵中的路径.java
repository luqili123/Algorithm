package 剑指offer;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
	[["a","b","c","e"],
	["s","f","c","s"],
	["a","d","e","e"]]
	但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 */
public class 矩阵中的路径 {
	public static boolean exist(char[][] board, String word) {
		if(board==null||board.length==0){
			return false;
		}
		boolean[][] visited=new boolean[board.length][board[0].length];
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				if(isExist(board,visited,i,j,0,word)){
					return true;
				}
			}
		}
		return false;
    }
	public static boolean isExist(char[][] board, boolean[][] visited,int x,int y,int index,String word){
		
		if(x<0||y<0||x>=board.length||y>=board[0].length||index>word.length()-1||visited[x][y]==true||board[x][y]!=word.charAt(index)){
			return false;
		}else if(index==word.length()-1){
			return true;
		}			
		if(board[x][y]==word.charAt(index)){
			visited[x][y]=true;
			boolean result=isExist(board,visited,x-1,y,index+1,word)||isExist(board,visited,x+1,y,index+1,word)
						 ||isExist(board,visited,x,y-1,index+1,word)||isExist(board,visited,x,y+1,index+1,word);
			if(!result){
				visited[x][y]=false;
				return false;
			}
			else{
				return true;
			}
		}
		return false;
		
	}
	public static void main(String[] args){
		char[][] board={{'a','b','c','e'},
						{'s','f','c','s'},
						{'a','d','e','e'}};
		String word="abcescfsadee";
		System.out.println(exist(board,word));
	}
}
