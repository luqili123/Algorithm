package 剑指offer;
/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构),B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * A:
 *   3
    / \
   4   5
  / \
 1   2
 B:
  4 
  /
 1
 
 
 * @author lqllq
 *思路：首先应该遍历A，寻找和B的根节点相同的，若没找到，则返回null，若找到了，则进一步判断A的子树和B的子树是否相同，有一个地方不同，就返回false
 */
public class 树的子结构 {
	public boolean isSubStructure(TreeNode A, TreeNode B) {		
        if(A==null||B==null){
            return false;
        }      
        if(A.val==B.val){
        	//进一步判断
            return isSub(A,B);
        }else{
        	//寻找相同的根节点
            return isSubStructure(A.left,B)||isSubStructure(A.right,B);
        }   
    }
    public static boolean isSub(TreeNode A, TreeNode B){
    	//B走到底了，说明，走的这条路全部都匹配，这条路发挥false
        if(B==null){
            return true;
        }
        if(A==null){
            return false;
        }
        if(A.val==B.val){
            return isSub(A.left,B.left)&&isSub(A.right,B.right);
        }else{
        	//有一点不同就返回false
            return false;
        }
    }
}
