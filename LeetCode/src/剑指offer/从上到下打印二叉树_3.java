package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * 
 * 正常的层次遍历，把偶数行的数据倒转.
 *	不能直接先插入右子树，再插左子树例如：
 *			1
 *		2		3
 *	4				5
 *
 *	正确的结果为[[1],[3,2],[4,5]]
 *如果先插入3，再插入2，则会导致下一行的顺序错乱
 * @author lqllq
 *
 */
public class 从上到下打印二叉树_3 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root==null){
			return  new ArrayList<>();
		}
		Queue<TreeNode> q1=new LinkedList<TreeNode>();
		Queue<TreeNode> q2=new LinkedList<TreeNode>();
		List<Integer> arr=null;
		List<List<Integer>> result=new ArrayList<List<Integer> >();
		//奇数行为false，偶数行为true
		boolean flag=true;		
		TreeNode temp=null;
		//第一行为奇数行，插入
		q1.add(root);
		while(!q1.isEmpty()||!q2.isEmpty()){
			//flag为true，说明上一次插入的是奇数行的数据，这次插入的是偶数行的数据
			if(flag){
				arr=new ArrayList<Integer>();
			
				//访问奇数行数据
				while(!q1.isEmpty()){					
					temp=q1.remove();
					arr.add(temp.val);
					//存储偶数行数据					
					if(temp.left!=null){
						q2.add(temp.left);
					}
					if(temp.right!=null){
						q2.add(temp.right);
					}
				}
				result.add(arr);
				flag=false;
			}else{
				arr=new ArrayList<Integer>();
				//访问偶数行数据
				while(!q2.isEmpty()){					
					temp=q2.remove();
					arr.add(temp.val);
					//存储偶数行数据
					if(temp.left!=null){
						q1.add(temp.left);
					}	
					if(temp.right!=null){
						q1.add(temp.right);
					}
									
				}
				//把偶数行的数据倒转
				Collections.reverse(arr);
				result.add(arr);
				flag=true;
			}
		}
		
		return result;
			
    }
}
