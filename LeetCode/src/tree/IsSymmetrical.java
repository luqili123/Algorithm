package tree;

public class IsSymmetrical {
	 public boolean isSymmetric(TreeNode root) {
	        return judge(root, root);
	    }
	 private boolean judge(TreeNode r1,TreeNode r2){
		 if(r1==null&&r2==null){
			 return true;
		 }
		 if(r1==null||r2==null)
			 return false;
		 if(r1.val!=r2.val)
			 return false;
		 return judge(r1.left, r2.right)&&judge(r1.right, r2.left);
	 }
}
