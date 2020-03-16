package 剑指offer;
/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 * @author lqllq
 *1、遍历链表，复制链表中的每个结点，并将复制的结点插入到该结点的后面。
 *	  例如，原链表为A->B->C, 遍历完毕后，链表变为A->A'->B->B'->C->C'，其中A‘，B'，C'是结点A，B，C的复制结点。
 *2、为复制结点的random指针赋值，如果原结点的random指针指向的是结点B，那么将复制结点的random指针指向结点B的复制结点B'。
 *3、将链表的原始结点与复制结点分割至两个链表，使原始结点构成一个链表，复制结点构成一个链表。
 */
public class 复杂链表的复制 {
	public static Node copyRandomList(Node head) {
		if(head==null){
			return null;
		}
		//复制节点
		Node p=head;
		Node q=null;
		while(p!=null){
			q=new Node(p.val);
			q.next=p.next;
			p.next=q;
			
			//移动到下一个节点
			p=q.next;
		}

		//复制random指针
		p=head;
		while(p!=null){
			if(p.random==null){
				p.next.random=null;
			}else{
				p.next.random=p.random.next;
			}
			//移动到下一个节点
			p=p.next.next;
		
		}
		
		//拆分链表
		p=head;
		Node h=head.next;
		q=h;
		while(q!=null){
			p.next=q.next;
			p=q;
			q=q.next;			
		}
//		p=h;
//		while(p!=null){
//			System.out.print(p.val+" ");
//			p=p.next;
//		}
		
		
       return h;
    }
	
	public static void main(String[] args){
		Node a=new Node(7);
		Node b=new Node(13);
		Node c=new Node(11);
		Node d=new Node(10);
		Node e=new Node(1);
		a.next=b;
		b.next=c;
		c.next=d;
		d.next=e;
		
		
		a.random=null;
		b.random=a;
		c.random=e;
		d.random=c;
		e.random=a;
		
		Node t=new Node(-1);
		t.next=null;
		copyRandomList(a);
	}
}
