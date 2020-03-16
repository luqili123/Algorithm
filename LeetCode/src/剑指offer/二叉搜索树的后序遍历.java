package 剑指offer;


/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * @author lqllq
 *
 */
public class 二叉搜索树的后序遍历 {
	 public static boolean verifyPostorder(int[] postorder) {
		 if(postorder==null){
			 return false;
		 }
		 if(postorder.length==1){
			 return true;
		 }
		 return verify(postorder,0,postorder.length-1);
		 
	 }
	 public static boolean verify(int[] postorder,int start,int end){
		 if(start<0||end>postorder.length){
			 return false;
		 }
		 if(start>=end){
			 return true;
		 }
		 int mid=start;
		 //比postorder[end]小的数是左子树，大的是右子树，找到左右子树分界点
		while(postorder[mid]<postorder[end]){
			if(mid==end){
				mid=end-1;
				break;
			}
			mid++;
		}
		
		 for(int i=mid;i<end;i++){
			 //mid到end下标之间的元素应该全部大于postorder[end],否则，就不是后序遍历的结果
			 if(postorder[i]<postorder[end]){
				 return false;
			 }
		 }
		 //左右子树检测通过，在进行递归判断
		 return verify(postorder,start,mid-1)&&verify(postorder,mid,end-1);
	 }
	 public static void main(String[] args){
			TreeNode a=new TreeNode(5);
			TreeNode b=new TreeNode(2);
			TreeNode c=new TreeNode(6);
			TreeNode d=new TreeNode(1);
			TreeNode e=new TreeNode(3);
			a.left=b;
			a.right=c;
			b.left=d;
			b.right=e;
			int[] postorder={3,2,1};
			System.out.println(verifyPostorder(postorder));
			
	}

}
