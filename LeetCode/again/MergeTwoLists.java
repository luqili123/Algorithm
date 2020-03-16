
public class MergeTwoLists {
	//可以使用递归
	//创建一个新链表l3用来存储合并后的链表
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 if(l1==null)
			 return l2;
		 if(l2==null)
			 return l1;
		 ListNode l3;
		 if(l1.val<=l2.val){
			 l3=l1;
			 l3.next=mergeTwoLists(l1.next, l2);
		 }
		 else {
			l3=l2;
			l3.next=mergeTwoLists(l1, l2.next);
		}

		return l3;
		 
	 }
}
