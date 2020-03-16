package tree;

public class IsValidBST {
public boolean isValidBST(TreeNode root) {
	if(root==null)
		return true;
	if(root.left!=null&&root.val<=getMax(root.left).val)
		return false;
	if(root.right!=null&&root.val>=getMin(root.right).val)
		return false;
	return isValidBST(root.left)&&isValidBST(root.right);
        
    }
private TreeNode getMax(TreeNode root) {
	TreeNode pNode=new TreeNode(0);
	while (root!=null) {
		
		pNode=root;
		root=root.right;
	}
	return pNode;
	
}
private TreeNode getMin(TreeNode root) {
	TreeNode pNode=new TreeNode(0);
	while (root!=null) {
		pNode=root;
		root=root.left;
	}
	return pNode;
}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
