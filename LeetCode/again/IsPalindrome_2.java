
public class IsPalindrome_2 {
	//可以先找到链表的中间位置
	//然后将链表后半部分翻转与前半部分一次比较
	public boolean isPalindrome(ListNode head) {
		if(head==null) return false;
		ReverseList reverseList=new ReverseList();
		ListNode left,right,mid;
		left=head;
		mid=findMid(head);//获得中间位置的接点指针
		right=reverseList.reverseList(mid.next);
		while (left!=null&&right!=null&&left.val==right.val) {
			left=left.next;
			right=left.next;
		}
		return right==null;//若链表有偶数个则左右两侧节点数相同，若为奇数则右侧节点比左侧少一个，因为中间位置的节点在比较时属于左侧，所以右侧会提前为空
		
	}
	//找到链表中间位置
	private  ListNode findMid(ListNode head){
		if(head==null)
			return null;
		ListNode p,q;
		p=head.next;
		q=head;
		while (p!=null&&p.next!=null) {
			q=q.next;
			p=p.next.next;
		}
		return q;
		
	}
}
