package 剑指offer;
/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * @author lqllq
 *
 */
public class 重建二叉树 {
	 public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		 if(pre==null||in==null||pre.length!=in.length||pre.length==0||in.length==0){
			 return null;
		 }		 
		 TreeNode root=build(pre,in,0,pre.length-1,0,in.length-1);
		 return root;
	 }
	 public  static TreeNode build(int[] pre,int in[],int preStart,int preEnd,int inStart,int inEnd){
		if(preStart>preEnd||inStart>inEnd){
			return null;
		}
		TreeNode root=new TreeNode(pre[preStart]);
		for(int i=inStart;i<=inEnd;i++){
			if(in[i]==pre[preStart]){
				root.left=build(pre,in,preStart+1,preStart+i-inStart,inStart,i-1);
				root.right=build(pre,in,preStart+i-inStart+1,preEnd,i+1,inEnd);
			}
		}
		return root; 
	 }
}


