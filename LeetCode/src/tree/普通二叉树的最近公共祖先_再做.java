package tree;

public class 普通二叉树的最近公共祖先_再做 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		if(root==null||root.val==p.val||root.val==q.val)
			return root;
		
       TreeNode left=lowestCommonAncestor(root.left, p, q);
       TreeNode right=lowestCommonAncestor(root.right, p, q);
       
       return left==null?right:right==null?left:root;
    }
	public static void main(String[] args) {
		
	}
}
