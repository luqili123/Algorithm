package 剑指offer;

public class 合并两个排序链表 {
	 public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 if((l1==null&&l2==null)){
			 return null;
		 }
		 if(l1==null||l2==null){
			 return l1==null?l2:l1;
		 }
		 
		 ListNode p=l1;
		 ListNode q=l2;
		 ListNode h=new ListNode(0);
		 ListNode n=h;
		 
		 while(p!=null&&q!=null){
			 if(p.val<=q.val){
				 n.next=p;
				 p=p.next;				
			 }else{
				 n.next=q;
				 q=q.next;
			 }
			 n=n.next;
		 }
		 
		 if(p!=null){
			 n.next=p;
		 }
		 if(q!=null){
			 n.next=q;
		 }
		 
		 return h.next;
	 }
	 
	 public static void main(String[] args){
		 ListNode a=new ListNode(1);
		 ListNode b=new ListNode(3);
		 ListNode c=new ListNode(4);
		 ListNode d=new ListNode(1);
		 ListNode e=new ListNode(2);
		 ListNode f=new ListNode(4);
		 a.next=b;
		 b.next=c;
		 
		 d.next=e;
		 e.next=f;
		 
		 ListNode h=mergeTwoLists(a,d);
		 while(h.next!=null){
			 System.out.print(h.val+" ");
			 h=h.next;
		 }
	 }
}
