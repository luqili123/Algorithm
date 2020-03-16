package 剑指offer;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){}
	TreeNode(int x) { val = x; }
	TreeNode(int x,TreeNode left,TreeNode rght){
		val=x;
		this.left=left;
		this.right=right;
	}
}
