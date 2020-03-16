package 基础算法;

import java.util.Stack;

public class 二叉树后序遍历 {
	/**
	 * 递归写法 左右中
	 * @param root
	 * @return
	 */
	public static void postorder(Node root) {
		if(root==null){
			return ;
		}
		if(root.left!=null){
			postorder(root.left);
		}
		if(root.right!=null){
			postorder(root.right);
		}
		System.out.print(root.val+" ");
		
		
    }
	
	/**
	 * 非递归写法   中右左
	 * 后序遍历相当于前序遍历左右子树翻转遍历的倒序
	 * @param root
	 */
	public static void postorder2(Node root) {
		if(root==null){
			return;
		}
		Stack<Node> s=new Stack<Node>();
		Stack<Integer> result=new Stack<Integer>();
		s.push(root);
		Node temp=null;
		while(!s.isEmpty()){
			temp=s.pop();
			result.add(temp.val);
			if(temp.left!=null){
				s.push(temp.left);
			}
			if(temp.right!=null){
				s.push(temp.right);
			}
			
		}
		while(!result.isEmpty()){
			System.out.print(result.pop()+" ");
		}
		
		
	}
	public static void main(String[] args){
		Node a=new Node(1);
		Node b=new Node(2);
		Node c=new Node(3);
		Node d=new Node(4);
		Node e=new Node(5);
		Node f=new Node(6);
		Node g=new Node(7);
		Node h=new Node(8);
		a.left=b;
		a.right=c;
		b.left=d;
		b.right=e;
		c.left=f;
		d.right=g;
		f.left=h;
		postorder(a);
		System.out.println();
		postorder2(a);
	}
}
