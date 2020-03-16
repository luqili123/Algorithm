package 剑指offer;
//

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * @author lqllq
 *	这里面的思想十分值得学习，如何在递归中中维护一个ArrayList呢？
 *	
 *	递归不是并发，同一时间，只会在其中一条路上走，此时就用这个list存这条路径，递归完成之后，在逐个删除遍历过的路径，然后再继续迭代
 */
public class 二叉树中和为某一值的路径 {
	private static List<List<Integer>> result;
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		result=new ArrayList<List<Integer>>();	
		
		path(root,sum,0,new ArrayList<Integer>());	
		
		return result;
    }
	/**
	 * 
	 * @param root
	 * @param sum
	 * @param plus
	 * @param path :用于存放当前节点所在的路径（随着遍历一直在变动） 
	 */
	public static void path(TreeNode root, int sum,int plus,List<Integer> path){
		//sum可能为负数，所以这里不需要判断sum>plus
		if(root==null){
			return;
		}
		//到当前节点位置的路径的节点值的和
		plus+=root.val;
		path.add(root.val);
		
		if(plus==sum&&root.left==null&&root.right==null){
			//得到一个符合要求的路径时，创建一个新的ArrayList，拷贝当前路径到其中，并添加到lists中
			result.add(new ArrayList<Integer>(path));
			return;
		}
		
		if(root.left!=null){
			//递归结束时，该留的路径已经记录了，不符合的路径也都不用理，删掉当前路径节点的值
			path(root.left,sum,plus,path);
			path.remove(path.size()-1);
		}
		if(root.right!=null){
			//递归结束时，该留的路径已经记录了，不符合的路径也都不用理，删掉当前路径节点的值
			path(root.right,sum,plus,path);
			path.remove(path.size()-1);
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
		TreeNode h=new TreeNode(4);
		a.left=b;
		a.right=c;
		b.left=d;
		b.right=e;
		c.left=f;
		d.right=g;
		f.left=h;
		
		TreeNode m=new TreeNode(-2);
		TreeNode n=new TreeNode(-3);
		m.right=n;
		
		System.out.println(pathSum(m,-5));
		System.out.println();
		
	}

	

}
