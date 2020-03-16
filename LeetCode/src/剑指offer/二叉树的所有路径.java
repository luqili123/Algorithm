package 剑指offer;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的所有路径 {
	
	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> res=new ArrayList<String>();
		path(root,res,"");
		return res;
		
	}
	public static void path(TreeNode root,List<String> res,String path){
		if(root==null){
			return;
		}
		//叶子结点
		if(root.left==null&&root.right==null){
			res.add(path+" "+root.val);
		}
		if(root.left!=null){
			path(root.left,res,path+" "+root.val);
		}
		if(root.right!=null){
			path(root.right,res,path+" "+root.val);
		}
	}
	
	public static void main(String[] args){
		
		TreeNode a=new TreeNode(1);
		TreeNode b=new TreeNode(2);
		TreeNode c=new TreeNode(3);
		TreeNode d=new TreeNode(4);
		TreeNode e=new TreeNode(5);
		TreeNode f=new TreeNode(6);
		TreeNode g=new TreeNode(7);
		TreeNode h=new TreeNode(8);
		a.left=b;
		a.right=c;
		b.left=d;
		b.right=e;
		c.left=f;
		d.right=g;
		f.left=h;
		System.out.println(binaryTreePaths(a));
		System.out.println();
		
	}
}
