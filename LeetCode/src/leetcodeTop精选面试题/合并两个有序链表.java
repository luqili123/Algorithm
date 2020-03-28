package leetcodeTop精选面试题;
/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
	示例：	
	输入：1->2->4, 1->3->4
	输出：1->1->2->3->4->4
	
 * @author lqllq
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode/
 * 思路：递归，
 * 我们可以如下递归地定义在两个链表里的 merge 操作（忽略边界情况，比如空链表等）：
 *  list1[0]+merge(list1[1:],list2)   list1[0]<list2[0]
	list2[0]+merge(list1,list2[1:])   otherwise
	也就是说，两个链表头部较小的一个与剩下元素的 merge 操作结果合并。
	算法
	我们直接将以上递归过程建模，首先考虑边界情况。
	特殊的，如果 l1 或者 l2 一开始就是 null ，那么没有任何操作需要合并，所以我们只需要返回非空链表。
	否则，我们要判断 l1 和 l2 哪一个的头元素更小，然后递归地决定下一个添加到结果里的值。如果两个链表都是空的，那么过程终止，所以递归过程最终一定会终止。
	思路2：迭代
	
 *
 */
public class 合并两个有序链表 {
	/**
	 * 迭代,下面的代码很妙，多体会，多体会！！！！
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		//创建一个结点，保存头节点
		ListNode h=new ListNode(0);
		//指向合并过程中的最后一个节点，然后根据l1，l2的比较结果，决定下一个节点是哪一个
		ListNode p=h;
		while(l1!=null&&l2!=null){
			if(l1.val<l2.val){
				p.next=l1;
				l1=l1.next;
			}else{
				p.next=l2;
				l2=l2.next;
			}
			p=p.next;
		}
		//有一个链表遍历完成了，将另一个剩余的节点连接到后面即可，因为本来就是有序的
		p.next=l1==null?l2:l1;
		return h.next;
		
    }
	/**
	 * 递归,好好体会return的时机
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		//结束条件
		//l1链表为空，则返回的节点应该是l2，因为l2非空
		if(l1==null){
			return l2;
		}else if(l2==null){
			return l1;
		}
		
		//选择
		//l1更小，那么上一层迭代的next应该连l1的节点
		if(l1.val<l2.val){
			l1.next=mergeTwoLists2(l1.next,l2);
			return l1;
			
		}else{
			l2.next=mergeTwoLists2(l1,l2.next);
			return l2;
		}
		
	}
}
