package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LevelOrder {
	 public List<List<Integer>> levelOrderBottom(TreeNode root) {
	        List<List<Integer>> l=new ArrayList<List<Integer>>();
	        addLevel(l,0,root);
	        Collections.reverse(l);
	        return l;
	    }
	    public void addLevel(List<List<Integer>> list, int level, TreeNode node){
	        if(node==null)return ;
	        if(list.size()-1<level)list.add(new ArrayList<Integer>());
	        list.get(level).add(node.val);
	        
	        addLevel(list,level+1,node.left);
	        addLevel(list,level+1,node.right);
	    }

}
