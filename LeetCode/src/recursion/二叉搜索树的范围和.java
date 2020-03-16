package recursion;

public class 二叉搜索树的范围和 {
	 public int rangeSumBST(TreeNode root, int L, int R) {
	        if(root==null)
	        	return 0;
	        return rangeSumBST(root.left, L, R)+rangeSumBST(root.right, L, R)+ ((root.val>=L&&root.val<=R) ? root.val :0);
	    }
}
