package 字节跳动;

import java.util.ArrayList;
import java.util.Stack;

public class 判断一棵树是否是二叉搜索树 {
	//中序遍历有序
	public static boolean isBST(Node root){
		if(root==null)
			return false;
		ArrayList<Integer> arr=new ArrayList<Integer>();
		Stack<Node> s=new Stack<Node>();
		Node p=root;
		while(!s.isEmpty()||p!=null){
			while(p!=null){
				s.push(p);
				p=p.left;
			}
			if(!s.isEmpty()){
				Node t=s.pop();
				arr.add(t.val);
				p=t.right;
			}
		}
		for(int i=1;i<arr.size()-1;i++){
			if(arr.get(i)<=arr.get(i-1)){
				return false;
			}
		}
		return true;
	}
	//递归
	public static boolean isBST2(Node root,int low,int high){
		if(root==null){
			return true;
		}
		if(root.val<=low||root.val>=high){
			return false;
		}
		return isBST2(root.left,low,root.val)&&isBST2(root.right,root.val,high);
	}
	
	public static void main(String[] args){
		Node a=new Node(5);
		Node b=new Node(3);
		Node c=new Node(8);
		Node d=new Node(1);
		Node e=new Node(4);
		Node f=new Node(7);
		Node g=new Node(2);
		Node h=new Node(6);
		a.left=b;
		a.right=c;
		b.left=d;
		b.right=e;
		c.left=f;
		d.right=g;
		f.left=h;
		System.out.print(isBST(a));
		System.out.print(isBST2(a,Integer.MIN_VALUE,Integer.MAX_VALUE));
		
	}
}
