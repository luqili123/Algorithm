package list;

public class DeleteNode {
	public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
		if(head==null||tobeDelete==null)
			return null;
		if(tobeDelete.next!=null){
			ListNode qListNode=tobeDelete.next;
			tobeDelete.val=qListNode.val;
			tobeDelete.next=qListNode.next;
		}else {
			ListNode qListNode=head;
			if(head.next==null)
				head=null;
			while (qListNode.next!=tobeDelete) {
				qListNode=qListNode.next;				
			}
			qListNode.next=null;
		}
		return head;
	}
}
