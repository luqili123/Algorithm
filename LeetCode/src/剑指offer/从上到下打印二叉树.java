package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * 
 * 层次遍历
 * @author lqllq
 *
 */
public class 从上到下打印二叉树 {
	public int[] levelOrder(TreeNode root) {
		if(root==null){
			return  new int[0];
		}
		Queue<TreeNode> q=new LinkedList<TreeNode>();
		ArrayList<Integer> arr=new ArrayList<Integer>();
		q.add(root);
		TreeNode temp=null;
		while(!q.isEmpty()){
			temp=q.remove();
			arr.add(temp.val);
			if(temp.left!=null){
				q.add(temp.left);
			}
			if(temp.right!=null){
				q.add(temp.right);
			}
		}
		int[] result=new int[arr.size()];
		for(int i=0;i<result.length;i++){
			result[i]=arr.get(i);
		}
		return result;
		
    }
}
