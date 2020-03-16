package list;




/**
 * 翻转链表
 * @author lqllq
 *
 */
public class ReverseList {
	public ListNode reverseList(ListNode head) {
		if(head==null)
			return null;
		if(head.next==null)
			return head;
		
		ListNode p=head;
		ListNode m=head.next;
		if(m.next==null){
			m.next=p;
			return m;
		}
		ListNode q=head.next.next;
		while(q.next!=null){
			m.next=p;
			p=m;
			m=q;
			q=q.next;
		}
		q.next=m;
		m.next=p;
		head.next=null;
		return q;
		
    }	
	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		ListNode l6=new ListNode(6);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		l5.next=l6;
		l6.next=null;
		ReverseList reverseList=new ReverseList();
		ListNode head=reverseList.reverseList(l1);
		System.out.println(head.val);
		while(head!=null){
			System.out.println(head.val);
			head=head.next;
		}
		
				
	}
}
