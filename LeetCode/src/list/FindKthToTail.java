package list;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QDecoderStream;

/**
 * 找到链表中倒数第K个结点
 * @author lqllq
 *
 */
public class FindKthToTail {
	/**
	 * 设链表的长度为 N。
	 * 设置两个指针 P1 和 P2，先让 P1 移动 K 个节点，则还有 N - K 个节点可以移动。
	 * 此时让 P1 和 P2 同时移动，可以知道当 P1 移动到链表结尾时，P2 移动到第 N - K 个节点处，该位置就是倒数第 K 个节点
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode FindKthtotail(ListNode head,int k) {
		if(head==null||k==0)
			return null;
		ListNode p=head;
		ListNode q=head;
		for(int i=1;i<k;i++){
			q=q.next;
			if(q==null)
				return null;
		}
		while(q.next!=null){
			p=p.next;
			q=q.next;
		}
		return p;
    }
}
