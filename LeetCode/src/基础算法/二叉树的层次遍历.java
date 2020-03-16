package 基础算法;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的层次遍历 {
	public static void levelOrder(Node root){
		if(root==null){
			return ;
		}
		//使用队列进行遍历
		Queue<Node> queue=new LinkedList<Node>();
		Node p=root;
		queue.add(p);
		while(!queue.isEmpty()){
			Node t=queue.remove();
			System.out.print(t.val+" ");
			if(t.left!=null){
				queue.add(t.left);
			}
			if(t.right!=null){
				queue.add(t.right);
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
		levelOrder(a);
	}

}

