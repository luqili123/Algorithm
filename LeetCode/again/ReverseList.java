
public class ReverseList {
	public ListNode reverseList(ListNode head){
		ListNode p,q,temp;
		p=head;
		q=null;
		while(p!=null){
			temp=p.next;
			p.next=q;
			q=p;
			p=temp;
			
		}
		head=q;
		return head;
		
	}
}
