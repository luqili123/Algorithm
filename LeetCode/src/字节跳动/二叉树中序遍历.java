package 字节跳动;

import java.util.Stack;

public class 二叉树中序遍历 {
	public static void middleOrder(Node root){
		if(root==null){
			return ;
		}
		if(root.left!=null){
			middleOrder(root.left);
		}
		System.out.print(root.val+" ");
		
		if(root.right!=null){
			middleOrder(root.right);
		}
		
	}
	
	public static void middleOrder2(Node root){
		if(root==null){
			return;
		}
		Stack<Node> s=new Stack<Node>();
		Node p=root;
		Node temp;
		while(!s.isEmpty()||p!=null){
			while(p!=null){
				s.push(p);
				p=p.left;
			}
			if(!s.isEmpty()){
				temp=s.pop();
				System.out.print(temp.val+" ");
				p=temp.right;
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
		middleOrder(a);
		System.out.println();
		middleOrder2(a);
	}
}	
