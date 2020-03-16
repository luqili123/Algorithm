package 剑指offer;
/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * @author lqllq
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 *   4
   /   \
  2     7
 / \   / \
1   3 6   9

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */
public class 二叉树的镜像 {
	 public TreeNode mirrorTree(TreeNode root) {
		 if(root==null){
			 return null;
		 }
		 TreeNode node=new TreeNode(root.val);
		 node.left=mirrorTree(root.right);
		 node.right=mirrorTree(root.left);
		 return node;
	 }
}
