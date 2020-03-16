package recursion;



/**
 * 因为是二叉搜索树，差值最小只能在相邻的节点之间
 * @author lqllq
 *
 */
public class 二叉搜索树节点最小距离 {
	private TreeNode pre=null;
	private int min=Integer.MAX_VALUE;
	 public int minDiffInBST(TreeNode root) {
		 dfs(root);
		 return min;
	 }
	 public void  dfs(TreeNode root) {
		if(root==null)
			return ;
		dfs(root.left);
		if(pre!=null){
			min=Math.min(root.val-pre.val, min);
		}
		pre=root;
		dfs(root.right);
	}
	 
}
