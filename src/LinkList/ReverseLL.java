package LinkList;

public class ReverseLL {
	//Approach1-Iterative
	private static Node reverse1(Node head) {
		Node prev=null;
		Node current=head;
		while(current!=null)
		{
			Node forward=current.next;
			current.next=prev;
			prev=current;
			current=forward;
		}
		return prev;
	}
	//Approach2-Recursive
	private static Node reverse2(Node head, Node current, Node prev){
		//base condition
		if(current==null){
			return prev;
		}
		Node forward=current.next;
		forward=reverse2(head,forward,current);
		current.next=prev;
		return forward;
	}
	//Approach3-Recursive
	private static Node reverse3(Node head){
		//base condition
		if(head==null || head.next==null)
			return head;

		Node newHead=reverse3(head.next);
		head.next.next=head;
		head.next=null;
		return newHead;
	}
public static void main(String[] args) {
	LL list=new LL();
	list.insert(1);
	list.insert(2);
	list.insert(3);
	list.insert(4);
	list.insert(5);

	//Approach1
	Node head=reverse1(list.head);
	printList(head);

	//Approach2
	head=reverse2(head, head, null);
	printList(head);

	//Approach3
	head=reverse3(head);
	printList(head);
}
public static void printList(Node head)
{
	Node temp=head;
	System.out.println("--link list---");
	while(temp!=null)
	{
		System.out.print(temp.data+" ");
		temp=temp.getNext();
	}
	System.out.println();
}

}
