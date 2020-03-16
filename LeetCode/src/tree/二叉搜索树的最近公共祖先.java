package tree;

/**
 * 在二叉搜索树中，两个节点的最近公共祖先满足root.val >= p.val && root.val <= q.val。
 * @author lqllq
 *
 */
public class 二叉搜索树的最近公共祖先 {
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null)
			return null;
		if(root.val>p.val&&root.val>q.val)
			return lowestCommonAncestor(root.left, p, q);
		if(root.val<q.val&&root.val<p.val)
			return lowestCommonAncestor(root.right, p, q);
		return root;
        
    }
	
	public static void main(String[] args) {
		TreeNode aNode=new TreeNode(2);
		TreeNode bNode=new TreeNode(1);
		TreeNode cNode=new TreeNode(3);
		aNode.left=bNode;
//		aNode.right=cNode;
		System.out.println(lowestCommonAncestor(aNode, aNode, bNode).val);
		;
		
	}
}
