package 剑指offer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * @author lqllq
 *
 */
public class 栈的压入与弹出顺序 {
	 public boolean validateStackSequences(int[] pushed, int[] popped) {
		 if(pushed==null||popped==null||pushed.length!=popped.length){
			 return false;
		 }
         if(pushed.length==0&&popped.length==0){
             return true;
         }
		 Stack<Integer> s=new Stack<Integer>();
		 int index=0;		 
		 s.push(pushed[0]);
		 for(int i=1;i<pushed.length;i++){	
			 //栈顶元素和popped数组比较，注意要循环
			 while(!s.isEmpty()&&s.peek()==popped[index]){
				 index++;
				 s.pop();	
			 }
			 s.push(pushed[i]);
		 }
		 //pushed数组全部插入之后，还有可能没有全部比较完，因为已经没有元素可以插入了，
		 //popped剩余元素的顺序必须和数组弹出元素顺序一模一样，不然就是错误
		 while(!s.isEmpty()&&index<popped.length){
			 if(s.peek()==popped[index]){
				 index++;
				 s.pop();
			 }
			 else{
				 return false;
			 }
		 }
		 return true;
	 }
}
