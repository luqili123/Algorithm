package 剑指offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * 输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4
 * @author lqllq
 *	思路：正常的可以想到中序遍历，一般的中序遍历是从小到大排列的，这里可以修改成从大到小排，因为二叉树是排序树，所以中序遍历需遍历右子树再遍历左子树即可
 *		  再使用一个变量，记录个数，到第k个时就停止并返回
 */
public class 二叉搜索树的第k大节点 {
	public static int kthLargest(TreeNode root, int k) {
		if(root==null){
			return -1;
		}
		
		Stack<TreeNode> s=new Stack<TreeNode>();
		int count=0;
		TreeNode p=root;
		TreeNode t;
		while(!s.isEmpty()||p!=null){
			while(p!=null){
				s.push(p);
				p=p.right;
			}
			if(!s.isEmpty()){
				t=s.pop();
				count++;
				if(count==k){
					return t.val;
				}
				p=t.left;
			
			}
		}
		
		return -1;
		
    }
	public static void main(String[] args){
		TreeNode a=new TreeNode(3);
		TreeNode b=new TreeNode(1);
		TreeNode c=new TreeNode(4);
		TreeNode d=new TreeNode(2);
		a.left=b;
		a.right=c;
		b.right=d;
		System.out.print(kthLargest(a,2));
	}
}
