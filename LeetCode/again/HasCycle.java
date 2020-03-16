
public class HasCycle {
	//设置快慢指针，若链表有环，则两个指针一定会再一次相遇
	public boolean hasCycle(ListNode head) {
		if(head==null||head.next==null){
			return false;
		}
		ListNode slow,fast;
		fast=head.next;
		slow=head;
		while(fast!=null){
			if (slow==fast) {
				return true;
			}else if (fast.next!=null) {
				slow=slow.next;
				fast=fast.next.next;
			}else {
				return false;
			}
		}                                                                              
		return false;
		
	}
}
