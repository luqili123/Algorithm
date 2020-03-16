package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 * @author lqllq
 *
 */
public class PrintBTree1 {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		  ArrayList<Integer> array=new ArrayList<Integer>();
		if(root==null)
			return array;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
      
        queue.add(root);
        while(!queue.isEmpty()){
        	TreeNode t=queue.poll();
        	if(t==null)
        		continue;
        	array.add(t.val);
        	queue.add(t.left);
        	queue.add(t.right);
        }
        return array;
        
        
        

    }
}
