package tree;

import java.util.HashMap;


/**
 * 重建二叉树
 * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

 * */
public class ReConstructBinaryTree {
	//解题思路：前序遍历的第一个值为根节点的值，使用这个值将中序遍历结果分成两部分，左部分为树的左子树中序遍历结果，右部分为树的右子树中序遍历的结果。
	
	//将中序遍历的数组转存为一个hashmap可以更快捷的找到各子树根节点的索引，如果用的话，从前序遍历找到根节点值之后，也可用for循环遍历中序数组找索引值
	private HashMap<Integer, Integer> indexForInordersMap=new HashMap<Integer,Integer>();
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        for (int i = 0; i < in.length; i++) {
			indexForInordersMap.put(in[i], i);
		}
        
        return reConstructBinaryTree(pre,0,pre.length-1,0);
    }
	//preL为某节点左子树在前序遍历中第一个节点索引，preR为最后一个节点索引，inL为某节点左左子树在中序遍历中第一个节点的索引
	private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
		//递归结束条件
		if(preL>preR){
			return null;
		}
		//该树的根节点一定是pre数组的第一个数
		TreeNode root=new TreeNode(pre[preL]);
		//寻找在中序遍历中根节点的位置
		int inIndex=indexForInordersMap.get(root.val);
		//根据中序遍历根节点位置可以确定左子树的长度
		int leftTreeSize=inIndex-inL;
		//分别对其左右子树做相同的递归操作
		root.left=reConstructBinaryTree(pre, preL+1, preL+leftTreeSize, inL);
		root.right=reConstructBinaryTree(pre, preL+leftTreeSize+1, preR, inL+leftTreeSize+1);
		return root;
	}
	public static void main(String[] args) {
		int[] pre={1,2,4,7,3,5,6,8};
		int[] in={4,7,2,1,5,3,8,6};
		ReConstructBinaryTree rTree=new ReConstructBinaryTree();
		rTree.reConstructBinaryTree(pre, in);
	}
}
