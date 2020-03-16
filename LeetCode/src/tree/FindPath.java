package tree;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * 
 * @author lqllq
 *
 */
public class FindPath {

	private  ArrayList<ArrayList<Integer>> arrays = new ArrayList<ArrayList<Integer>>();

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
	    backtracking(root, target, new ArrayList<>());
	    return arrays;
	}

	// 回溯法，需要记录路径位置，通过传递path的引用来记录
	private void backtracking(TreeNode rootNode, int target, ArrayList<Integer> path) {
		if (rootNode == null)
			return;
		path.add(rootNode.val);
		target -= rootNode.val;
		if (target == 0 && rootNode.left == null && rootNode.right == null) {
			arrays.add(new ArrayList<>(path));
		} else {
			backtracking(rootNode.left, target, path);
			backtracking(rootNode.right, target, path);
		}
		// 若路径错误，则删除新加入的节点
		path.remove(path.size() - 1);
	}
}
