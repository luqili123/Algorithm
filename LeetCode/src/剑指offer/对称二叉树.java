package 剑指offer;

public class 对称二叉树 {
	public boolean isSymmetric(TreeNode root) {
		if(root==null){
			return true;
		}	
		return isMirror(root,root);
    }
	public boolean isMirror(TreeNode n1,TreeNode n2){
		if(n1==null&&n2==null){
			return true;
		}else if(n1==null||n2==null){
			return false;
		}else{
			//两个遍历指针同时对称移动
			return (n1.val==n2.val)&&isMirror(n1.left,n2.right)&&isMirror(n1.right,n2.left);
		}
	}
}
