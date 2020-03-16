package 字节跳动;

import java.util.Stack;

public class 二叉树原地展开成链表 {
	
	//后序遍历递归方法
	public static void flatten(TreeNode root){
		if(root==null){
			return ;
		}
		flatten(root.left);
		flatten(root.right);
		TreeNode temp=root.right;
		root.right=root.left;
		root.left=null;
		while(root.right!=null){
			root=root.right;
		}
		root.right=temp;
	}
	//先序遍历非递归
	public static void flatten2(TreeNode root){
		if(root==null){
			return;
		}
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode p=stack.pop();
			if(p.left!=null){
				//找到左子树最右的节点
				TreeNode temp=p.left;
				while(temp.right!=null)
				{
					temp=temp.right;
				}
				//把右子树连接到左子树的最右节点的右子树
				temp.right=p.right;
				//再将左子树移动到右子树位置
				p.right=p.left;
				p.left=null;				
			}
			if(p.right!=null){
				stack.push(p.right);
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t4=new TreeNode(4);
		TreeNode t5=new TreeNode(5);
		TreeNode t6=new TreeNode(6);
		TreeNode t7=new TreeNode(7);
		t1.left=t2;
		t1.right=t5;
		t2.left=t3;
		t2.right=t4;
		t5.left=t6;
		t5.right=t7;
		
		flatten2(t1);
		
		while(t1!=null){
			System.out.print(t1.value);
			t1=t1.right;
		}
	}

}

class TreeNode{
	int value;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int v){
		this.value=v;
	}
}
