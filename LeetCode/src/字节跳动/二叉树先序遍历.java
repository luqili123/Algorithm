package 字节跳动;

import java.util.Stack;

public class 二叉树先序遍历 {
	//递归
	public static void preOrder1(Node root){
		
		if(root==null){
			return;
		}
		//1.访问节点
		System.out.print(root.val);	
		preOrder1(root.left);	
		preOrder1(root.right);
	}
	
	//非递归
	public static void preOrder2(Node root){
		if(root==null)
			return;
		Stack<Node> stack=new Stack<Node>();
		Node p=root;
		stack.add(p);		
		while(stack.size()>0){
			//弹出
			p=stack.pop();
			System.out.print(p.val+" ");
			
			if(p.right!=null){
				stack.add(p.right);
			}
			if(p.left!=null){
				stack.add(p.left);
			}
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
		preOrder1(a);
		System.out.println();
		preOrder2(a);
	}

}
	
	

class Node{
	Node left;
	Node right;
	int val;
	
	public Node(int v){
		this.val=v;
		this.left=null;
		this.right=null;
	}
}


 	

