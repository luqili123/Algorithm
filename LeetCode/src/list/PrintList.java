package list;

import java.util.ArrayList;
import java.util.Stack;

public class PrintList {
	//方法一：递归，代码简单，思路很难
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		if(listNode!=null){
			arrayList.addAll(printListFromTailToHead(listNode.next));
			arrayList.add(listNode.val);
		}
		return arrayList;       
    }
	//方法二：头插法
	public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		ListNode head=new ListNode(-1);		
		while(listNode!=null){
			ListNode p=listNode.next;
			listNode.next=head.next;
			head.next=listNode;
			listNode=p;
		}
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		ListNode q=head.next;
		while(q!=null){
			arrayList.add(q.val);
			q=q.next;
		}
		return arrayList;
	}
	//方法三:使用栈
	public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
		Stack<Integer> stack=new Stack<Integer>();
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		while(listNode!=null){
			stack.add(listNode.val);
			listNode=listNode.next;
		}
		while(!stack.isEmpty()){
			arrayList.add(stack.pop());
		}
		return arrayList;
	}
}
