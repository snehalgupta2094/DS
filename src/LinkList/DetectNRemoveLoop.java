package LinkList;

import java.util.HashMap;
import java.util.HashSet;

public class DetectNRemoveLoop
{
	//print LL
	public static void printLL(ListNode head){
		ListNode temp=head;
		while (temp.next!=null){
			System.out.println(temp.val);
			temp=temp.next;
		}
	}
	//Approach2: Floyd Warshall
	public static void detectNRemoveLoop1(ListNode head){

	}
	//Approach1: HashMap
	public static void detectNRemoveLoop(ListNode head){
		HashSet<ListNode> visited=new HashSet<>();
		ListNode temp=head;
		ListNode prev=null;
		while (temp!=null){
			if(visited.contains(temp))
			{
				prev.next=null;
				return;
			}
			visited.add(temp);
			prev=temp;
			temp=temp.next;
		}
		System.out.println("No Loop");

	}
	public static void main(String[] args) 
	{
		ListNode n6=new ListNode(6,null);
		ListNode n5=new ListNode(5,n6);
		ListNode n4=new ListNode(4,n5);
		ListNode n3=new ListNode(3,n4);
		ListNode n2=new ListNode(2,n3);
		ListNode head=new ListNode(1,n2);
		n6.next=n3;

		//Approach1: HashMap
		detectNRemoveLoop(head);
		printLL(head);
	}
}
