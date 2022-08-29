package LinkList;

import java.util.HashSet;

public class IsCircular
{
	public static void detectCircle(ListNode head){
		ListNode curr=head;
		while( curr!=null && curr.next!=head){
			System.out.println("here");
			curr=curr.next;
		}

		if (curr == null) {
			System.out.println("Not circular");
		} else {
			System.out.println("Circular");
		}
	}

	public static void main(String[] args) 
	{
		ListNode n6=new ListNode(6,null);
		ListNode n5=new ListNode(5,n6);
		ListNode n4=new ListNode(4,n5);
		ListNode n3=new ListNode(3,n4);
		ListNode n2=new ListNode(2,n3);
		ListNode head=new ListNode(1,n2);
		n6.next=head;

		detectCircle(head);
	}
}
