package list;

public class RemoveNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode q = new ListNode(0);
		ListNode p = new ListNode(0);
		q = head;
		p = head;
		for (int i = 0; i < n; i++) {
			p = p.next;
//			 System.out.println("val:"+p.val);
		}
		//n等于链表长度（长度为1的情况以及包含在里面）
		if (p == null){
			head = head.next;
			return head;
		}
		while (p.next != null) {
			p = p.next;
			q = q.next;
		}

		if (n == 1)
			q.next = null;

		else {
			q.next = q.next.next;
		}

		return head;

	}

	public static void main(String[] args) {
		// 初始化链表
		ListNode head = new ListNode(1);
//		ListNode pListNode = head;
		ListNode q = head;
//		for (int i = 0; i < 6; i++) {
//			ListNode listNode = new ListNode(i);
//			pListNode.next = listNode;
//			pListNode = pListNode.next;
//		}
		while (q != null) {
			System.out.print(q.val + "  ");
			q = q.next;

		}
		System.out.println();
		//
		RemoveNthFromEnd rEnd = new RemoveNthFromEnd();
		q = rEnd.removeNthFromEnd(head, 1);
		while (q != null) {
			System.out.print(q.val + "  ");
			q = q.next;
		}

	}
}
