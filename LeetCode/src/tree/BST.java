package tree;
/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 
 * 
 * 思路：在后序遍历得到的序列中，最后一个数字是树的根结点的值。数组中前面的数字可以分为两部分：第一部分是左子树结点的值，它们都比根结点的值小；
 * 第二部分是右子树结点的值，它们都比根结点的值大。以数组{5， 7， 6， 9， 11， 10， 8}为例，后序遍历的结果中最后一个值8就是根结点，在这个数组中前3个数字5，7， 6都比8小是根结点8的左子树结点；
 * 后3个数字9， 11， 10都比8大，是根结点8的右子树结点。接下来用同样的方法确定与数组每一部分对应的子树的结构。这其实就是一个递归的过程。
 *
 * @author lqllq
 *
 */
public class BST {
	public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0)
        	return false;
        return Verify(sequence, 0, sequence.length-1);
    }
	private boolean Verify(int[] sequence,int first,int last) {
		if(last-first<=1)
			return true;
		int rootValue=sequence[last];
		int i=first;
		while(i<last&&sequence[i]<=rootValue)
			i++;
		for(int j=i;j<last;j++){
			if(sequence[j]<sequence[last])
				return false;
		}
		return Verify(sequence, 0, i-1)&&Verify(sequence, i, last-1);
	}
}
