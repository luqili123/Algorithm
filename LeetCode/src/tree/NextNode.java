package tree;
/**

 * 
 * 首先这道题给出的是中序遍历这个二叉树，那么就是左根右。我们在求一个结点的下一个结点，那么这个时候我们需要分情况讨论：

	1、如果该结点有右子树，则该结点的下一个结点为该结点的右子树的最左结点。

	2、如果该结点没有右子树，则又分两种情况讨论：
 *情况一：如果该结点为该结点的父结点的左孩子，则该结点的父结点pNode.next则为下一个结点。
 * 
 *情况二：如果该结点为该结点的父结点的右孩子，则该结点的父结点的父结点的父结点，直到其中的一个父结点是这个父结点的左孩子，则该父结点的父结点为下一个结点。
 * @author lqllq
 *
 */
public class NextNode {
	public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
		if (pNode==null) {
			return null;
		}
        if(pNode.right!=null){
        	TreeLinkNode qNode=pNode.right;
        	while(qNode.left!=null){
        		qNode=qNode.left;
        	}
        	return qNode;
        }else {
        	//后面两种情况可以合并成一种，因为都是判断pnode是不是parent的左子树
        	TreeLinkNode parent=null;;
			while(pNode.next!=null){
				parent=pNode.next;
				if(parent.left==pNode) return parent;
				pNode=parent;
			}
			return null;
			
		}
    }
	
}
