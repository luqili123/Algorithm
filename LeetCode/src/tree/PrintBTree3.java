package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推
 * 利用一个boolean类型的变量
 * @author lqllq
 *
 */
public class PrintBTree3 {
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		ArrayList<ArrayList<Integer>> arrayList=new ArrayList<ArrayList<Integer>>();
		if(pRoot==null)
			return arrayList;
		boolean reverse=false;
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
			if(!aIntegers.isEmpty()){
				if(reverse)
					Collections.reverse(aIntegers);
				reverse=!reverse;
				arrayList.add(aIntegers);
			}
		
		}
		return arrayList;
    }
}
