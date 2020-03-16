
public class RemoveNthFromEnd {
	//删除倒数第n个元素，要求一趟完成
	//可以设两个指针，第一个指针p先移动n-1个位置，然后q指针与p一起
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p,q;
		p=head;q=head;
		for(int i=0;i<n;i++)
			p=p.next;
		if(p==null){//n等于链表长度，删除头指针
			head=head.next;
			return head;
		}
		while (p.next!=null) {
			p=p.next;
			q=q.next;		
		}
		if(n==1){
			q.next=null;
		}else {
			q.next=q.next.next;
		}
		
		return head;
		
	}
}
