package list;

import java.util.HashMap;


/**
 * 删除链表中重复的节点
 * @author lqllq
 *
 */
public class DeleteDuplicatedNode {
	/**
	 * 时间复杂度为O(n)
	 * 空间复杂度为hashmap
	 * @param pHead
	 * @return
	 */
	//遍历法，将链表存入HashMap中，记录次数，大于等于2的节点丢掉
	public ListNode deleteDuplication(ListNode pHead)
    {	
		if(pHead==null)
			return null;
		HashMap<Integer, Integer> hashMap=new HashMap<Integer, Integer>();
		ListNode p=pHead;
		while(p!=null){
			if(hashMap.containsKey(p.val))
				hashMap.put(p.val, hashMap.get(p.val)+1);
			else {
				hashMap.put(p.val, 1);
			}
			p=p.next;
		}
		//若头结点有重复，则向后移动头结点，直到找到第一个没有重复的节点
		while(hashMap.get(pHead.val)>=2){
			pHead=pHead.next;
			//若pHead为空，说明移动到了结尾，说明整个链表都是重复元素例如：{1,1,1,1,1,1,}、{1,1,2,2,3,3，3}
			if(pHead==null)
				return null;
		}
		p=pHead;
		ListNode q=p.next;
		//遍历链表
		while(q!=null){
			if(hashMap.get(q.val)>=2){
				//若q指向的节点有重复，则继续往下寻找，直到找到第一个不重复的节点
				while(hashMap.get(q.val)>=2){
					q=q.next;
					//若在寻找过程中q为null，说明遍历结束，q走过的地方都是重复元素
					if(q==null){
						p.next=null;
						return pHead;
					}
				}
				p.next=q;
			}
			p=p.next;
			q=q.next;
		}
		
		
		return pHead;
    }
	/**
	 * 三指针
	 * 情况比较多
	 * 1、头结点重复
	 * 2、整个链表重复
	 * 3、正常情况
	 * 需要注意cur为空时的返回值
	 * @param pHead
	 * @return
	 */
	public ListNode deleteDuplication2(ListNode pHead)
    {	
		if(pHead==null||pHead.next==null)
			return pHead;
		//三指针
		//因为头结点也有可能删除，所以在头结点之前再创建一个节点pre
		ListNode pre=new ListNode(0);
		pre.next=pHead;
		ListNode mid=pHead;
		ListNode cur=mid.next;
		//若开头有重复
		while(mid.val==cur.val){
			while(mid.val==cur.val){
				cur=cur.next;
				if(cur==null)
					return null;
			}
			pHead=cur;
			pre.next=pHead;
			mid=pHead;
			cur=cur.next;
			if(cur==null)
				return pHead;
		}
		pre=pre.next;
		mid=mid.next;
		cur=cur.next;
		while(cur!=null){
			if(mid.val==cur.val){
				while(mid.val==cur.val){
					cur=cur.next;
					if(cur==null){
						pre.next=null;
						return pHead;
					}
				}
				pre.next=cur;
				mid=cur;
				cur=cur.next;
			}else{
				pre=pre.next;
				mid=mid.next;
				cur=cur.next;
			}
			
		}
		return pHead;
		
		
		
    }
	
	
	
	public static void main(String[] args) {
		ListNode p1=new ListNode(1);
		ListNode p2=new ListNode(1);
		ListNode p3=new ListNode(1);
		ListNode p4=new ListNode(1);
		ListNode p5=new ListNode(1);
		ListNode p6=new ListNode(1);
		ListNode p7=new ListNode(5);
		p1.next=p2;
		p2.next=p3;
		p3.next=p4;
		p4.next=p5;
		p5.next=p6;
		p6.next=p7;
		p7.next=null;
	
		DeleteDuplicatedNode ddn=new DeleteDuplicatedNode();
		ListNode p=ddn.deleteDuplication2(p1);

	
		while (p!=null) {
			System.out.println(p.val);
			p=p.next;
			
		}
		
	}
	}
