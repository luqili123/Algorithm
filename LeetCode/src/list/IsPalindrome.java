package list;

public class IsPalindrome {
public boolean isPalindrome(ListNode head) {
	//简单的方法就是遍历链表，存入数组比较，但空间复杂度显然不为O(1)
	//我们可以利用快慢指针，指针每次移动一格，另一个移动两格，当快指针移动到表尾是，慢指针的位置就是链表中间位置，然后将链表右半边的链表翻转，与左半边比较
	if(head==null)
		return true;
	ListNode mid=findMid(head);
	mid.next=reverse(mid.next);
	ListNode p=new ListNode(0);
	ListNode q=new ListNode(0);
	p=head;q=mid.next;
	while(p!=null&&q!=null&&p.val==q.val)
	{
		q=q.next;
		p=p.next;
	}
	
	return q==null;//若链表有偶数个则左右两侧节点数相同，若为奇数则右侧节点比左侧少一个，因为中间位置的节点在比较时属于左侧，所以右侧会提前为空
        
    }

//找到链表中间位置
private  ListNode findMid(ListNode head){
	if(head==null)
		return null;
	ListNode slow=new ListNode(0);
	ListNode quick=new ListNode(0);
	slow=head;quick=head.next;
	while(quick!=null&&quick.next!=null){
		slow=slow.next;
		quick=quick.next.next;
	}
	
	return slow;
	
}
    //翻转链表
private ListNode reverse(ListNode head){
	ListNode p=head;
	ListNode q=null;
	ListNode temp;
	while(p!=null){
		temp=p.next;
		p.next=q;
		q=p;
		p=temp;
	}
//	while (q != null) {
//		System.out.print(q.val + "  ");
//		q = q.next;
//
//	}
	return q;
	
	
}

	public static void main(String[] args) {
		IsPalindrome isPalindrome=new IsPalindrome();
		// 初始化链表
		ListNode head = new ListNode(1);
		ListNode pListNode = head;
		ListNode q = head;
		int[] a={0,0};
		for (int i = 0; i < 2; i++) {
			ListNode listNode = new ListNode(a[i]);
			pListNode.next = listNode;
			pListNode = pListNode.next;
		}
		while (q != null) {
			System.out.print(q.val + "  ");
			q = q.next;

		}
		System.out.println();
		System.out.println(isPalindrome.isPalindrome(head));
		
	}
}





