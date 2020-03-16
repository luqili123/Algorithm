package 剑指offer;

import java.util.Stack;
/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 我们希望将这个二叉搜索树转化为双向循环链表。
 * 链表中的每个节点都有一个前驱和后继指针。
 * 对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左
 * 指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 * @author lqllq
 *https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 *
 *中序遍历，在遍历的过程中改变指针指向
 *
 */
public class 二叉搜索树与双向链表 {
	public static  TreeNode treeToDoublyList(TreeNode root) {
        if(root==null){
        	return null;
        }
       
        TreeNode tail=root;    
        //先找和最大值
        while(tail.right!=null){
        	tail=tail.right;
        }        
        Stack<TreeNode> s=new Stack<TreeNode>();
        TreeNode p=root;
        //第一次循环是，会先找到最小的数，最大的数是其前驱节点
        TreeNode curr=null;
        TreeNode pre=tail;
        while(!s.isEmpty()||p!=null){
        	while(p!=null){
        		s.push(p);
//        		System.out.print(p.val+" ");
        		p=p.left;
        		
        	}
        	if(!s.isEmpty()){       		
        		curr=s.pop();
//        		System.out.print(curr.val+" ");
        		p=curr.right;
        		//修改指针
        		curr.left=pre;
        		pre.right=curr;       		       		
        		//将当前节点编程前驱节点
        		pre=curr;   		
        	}
        	//变成循环链表之后，会变成无限循环
        	if(pre.val==tail.val){
        		break;
        	}
        }
        //头节点是最后一个节点的前驱
        TreeNode head=curr.right;
        
        return head;
    }
	public static void main(String[] args){
		TreeNode a=new TreeNode(10);
		TreeNode b=new TreeNode(5);
		TreeNode c=new TreeNode(15);
		TreeNode d=new TreeNode(2);
		TreeNode e=new TreeNode(8);
		TreeNode f=new TreeNode(13);
		TreeNode g=new TreeNode(18);
		TreeNode h=new TreeNode(1);
		TreeNode i=new TreeNode(7);
		TreeNode j=new TreeNode(9);
		TreeNode k=new TreeNode(11);
		TreeNode l=new TreeNode(20);
		
		a.left=b;
		a.right=c;
		b.left=d;
		b.right=e;
		d.left=h;
		e.left=i;
		e.right=j;
		c.left=f;
		c.right=g;
		f.left=k;
		g.right=l;
		TreeNode head=treeToDoublyList(a);
		
		for(int m=0;m<12;m++){
			System.out.print(head.val+" ");
			head=head.right;
		}
	}
}
