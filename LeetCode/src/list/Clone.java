package list;

import com.sun.xml.internal.messaging.saaj.packaging.mime.Header;

/**
 * 复杂链表的复制。
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 思路：
 * 第一步，在每个节点的后面插入复制的节点。
 * 第二步，对复制节点的 random 链接进行赋值。
 * 第三步，拆分。
 * @author lqllq
 *
 */
public class Clone {
	public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null)
        	return null;
        RandomListNode p=pHead;
        //复制
        while(p!=null){
        	RandomListNode clone=new RandomListNode(p.label);
        	clone.next=p.next;
        	p.next=clone;
        	p=clone.next;
        }
        //对random赋值
        p=pHead;
        while(p!=null){
        	RandomListNode clone=p.next;
        	if(p.next!=null){
        		clone.random=p.random.next;
        	}
        	
        	p=clone.next;
        }
        //拆分
        p=pHead;
        RandomListNode head=p.next;
        RandomListNode q=head;
        while(p.next!=null){
        	p.next=q.next;
        	p=q.next;
        	q.next=p.next;
        	q=p.next;
        	
        }
        return head;
    }
}
