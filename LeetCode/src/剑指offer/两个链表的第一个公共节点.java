package 剑指offer;
/**
 * 输入两个链表，找出它们的第一个公共节点。
 * 
 * A:0->9->1->2->4
 *          |
 * B:       3
 *  A链表和B链表的第一个公共节点为2
 * @author lqllq
 *	思想：双指针，由于两个链表长度不知道，自然也不知道哪个节点是重合的，一个节点一个节点的尝试，时间复杂度是n^2.
 *		  我们可以创建两个指针，为了让两个指针同时移动到重合节点，我们需要消除链表长度不一致带来的不同时到重合节点 的问题。
 *	处理方法：我们使用两个指针 node1，node2 分别指向两个链表 headA，headB 的头结点，然后同时分别逐结点遍历，当 node1 到达链表 headA 的末尾时，
 *			 重新定位到链表 headB 的头结点；当 node2 到达链表 headB 的末尾时，重新定位到链表 headA 的头结点。
			 这样，当它们相遇时，所指向的结点就是第一个公共结点。这样就消除了长度不一致的问题。
 */
public class 两个链表的第一个公共节点 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
        	return null;
        }
        ListNode a=headA;
        ListNode b=headB;
        while(a!=b){
        	if(a==null){
        		a=headB;
        	}else{
        		a=a.next;
        	}
        	if(b==null){
        		b=headA;
        	}else{
        		b=b.next;
        	}
        }
        return a;
        
    }
}
