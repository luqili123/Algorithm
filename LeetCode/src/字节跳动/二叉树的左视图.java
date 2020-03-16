package 字节跳动;

import java.util.LinkedList;
import java.util.Queue;



public class 二叉树的左视图 {
	//双队列
	public static void leftView(Node root){
		if(root==null){
			return;
		}
		Queue<Node> q1=new LinkedList<Node>();
		Queue<Node> q2=new LinkedList<Node>();
		boolean flag=true;
		int c=1;
		q1.add(root);
		while(!q1.isEmpty()||!q2.isEmpty()){
			if(flag){
				Node t=q1.remove();
				if(c==1){
					System.out.print(t.val+" ");
					c=0;
				}
				if(t.left!=null){
					q2.add(t.left);
					
				}
				if(t.right!=null){
					q2.add(t.right);
					
				}
				if(q1.isEmpty()){
					flag=false;
					c=1;
				}
			}else{
				Node t=q2.remove();
				if(c==1){
					System.out.print(t.val+" ");
					c=0;
				}
				
				if(t.left!=null){
					q1.add(t.left);
					
				}
				if(t.right!=null){
					q1.add(t.right);
					
				}
				if(q2.isEmpty()){
					flag=true;
					c=1;
				}
			}
		}		
	}
	
	public static void leftView2(Node root){
		if(root==null){
			return;
		}
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		//当前层的节点个数
		int size=1;
		//下一层的节点个数
		int next=0;
		while(!q.isEmpty()){
			next=0;
			//循环一次，遍历一层，第一个数就是需要的节点
			for(int i=0;i<size;i++){
				Node t=q.remove();
				if(i==0){
					System.out.print(t.val+" ");
				}
				if(t.left!=null){
					q.add(t.left);
					next++;
				}
				if(t.right!=null){
					q.add(t.right);
					next++;
				}
			}
			size=next;

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
		leftView(a);
		System.out.println();
		leftView2(a);
		
	}

}
