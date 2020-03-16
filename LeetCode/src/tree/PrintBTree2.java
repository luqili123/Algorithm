package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行
 * @author lqllq
 *
 */
public class PrintBTree2 {
	ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
	    Queue<TreeNode> queue=new LinkedList<TreeNode>();
	    ArrayList<ArrayList<Integer>> arrayList=new ArrayList<ArrayList<Integer>>();
	    if(pRoot==null)
	    	return arrayList;
	    queue.add(pRoot);
	    while(!queue.isEmpty()){
	    	ArrayList<Integer> aIntegers=new ArrayList<Integer>();
	    	int size=queue.size();
	    	while((size--)>0){
	    		TreeNode t=queue.poll();
		    	if(t==null)
		    		continue;
		    	aIntegers.add(t.val);
		    	queue.add(t.left);
		    	queue.add(t.right);
	    	}
	    	if(!aIntegers.isEmpty())
	    		arrayList.add(aIntegers);    	
	    }
	    return arrayList;
    }
}
