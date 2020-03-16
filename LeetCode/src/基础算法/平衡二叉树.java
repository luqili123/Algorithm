package 基础算法;
/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *   
 *  3
   / \
  9  20
    /  \
   15   7
 * @author lqllq
 *	思路：递归，看以当前节点为根节点的树的左右子树高度差是否小于等于1，其实就是比较左右子树的最大高度。然后递归比较以左右孩子为根节点的子树
 */
public class 平衡二叉树 {
	public boolean isBalanced(TreeNode root) {
		if(root==null){
			return true;
		}
		int leftDepth=maxDepth(root.left);
		int rightDepth=maxDepth(root.right);
		
		return Math.abs(leftDepth-rightDepth)<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }
	public int maxDepth(TreeNode root){
		if(root==null){
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
	}
}
