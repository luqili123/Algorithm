package list;

public class HasCycle {
	/*
	 * 设置两个指针，fast和slow，fast每次走两步，slow每次走一步， 想象一下，如果链表有环是封闭的话，两个指针在里面就形成了一个追击问题，
	 * 是早晚会相遇的，我们就依据这一思路来做题。
	 */
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode slow = new ListNode(0);
		ListNode fast = new ListNode(0);
		slow = head;
		fast = head.next;
		while (fast != null ) {
			if (fast==slow)
				return true;
			else if(fast!=null&&fast.next!=null){
				fast=fast.next.next;
				slow=slow.next;
			}
			else {
				return false;
			}

		}
		return false;

	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
