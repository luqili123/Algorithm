package leetcodeTop精选面试题;
/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
       如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
       您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 * @author lqllq
 * 思路1：计算出和然后再拆开
 * 思路2：记录进位信息
 */
public class 两数相加 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p=l1;
		ListNode q=l2;
		//进位
		int carry=0;
		//记录链表对应位上两个数加进位的和
		int sum=0;
		//新节点的头节点
		ListNode head=new ListNode(-1);
		ListNode t=head;
		while(q!=null&&p!=null){
			sum=carry+q.val+p.val;
			//计算进位
			carry=sum/10;
			//创建节点
			t.next=new ListNode(sum%10);
			t=t.next;
			q=q.next;
			p=p.next;
		}
		while(q!=null){
			sum=carry+q.val;
			carry=sum/10;
			t.next=new ListNode(sum);
			t=t.next;
			q=q.next;
		}
		while(p!=null){
			sum=carry+p.val;
			carry=sum/10;
			t.next=new ListNode(sum);
			t=t.next;
			p=p.next;
		}
		//最后一位数加起来之后还有进位
		if(carry>0){
			t.next=new ListNode(carry);
		}
		return head.next;
    }
}
