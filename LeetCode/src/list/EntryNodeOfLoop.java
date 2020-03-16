package list;

import Math.number_of1;

/**
 * 链表中环 的入口结点
 * 设立快慢指针，快指针fast每次移动两个位置，慢指针每次移动一个位置，若存在环，怎两指针必然在环内相遇，此时令其中一个指针从开始移动，两个指针速度位1，相遇时就是环的入口
 * @author lqllq
 *
 */
public class EntryNodeOfLoop {
	public ListNode entryNodeOfLoop(ListNode pHead)
    {
		if(pHead==null||pHead.next==null)
			return null;
        ListNode fast=pHead.next.next;
        ListNode slow=pHead.next;
        while(fast!=null||fast.next!=null){
        	if(fast==slow){
        		fast=pHead;
        		while(fast!=slow){
        			fast=fast.next;
        			slow=slow.next;
        		}
        		return fast;
        	}
        	slow=slow.next;
        	fast=fast.next.next;
        }
        return null;
    }
}
