package tree;

public class MaxDepth {
	//树的最大高度
	public int maxDepth(TreeNode root) {
        int high=0;
        if(root==null)
            return high;
         int leftDepth=maxDepth(root.left)+1;
        int rightDepth=maxDepth(root.right)+1;
        return leftDepth>rightDepth?leftDepth:rightDepth;
       
    }
}
