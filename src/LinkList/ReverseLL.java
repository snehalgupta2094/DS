package LinkList;

public class ReverseLL {
public static void main(String[] args) {
	LL list=new LL();
	list.insert(1);
	list.insert(2);
	list.insert(3);
	list.insert(4);
	list.insert(5);
	Node head=reverseL(list.head);
	//head=reverseLL(list.head);
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

private static Node reverseL(Node head)
{
	Node prev=null;
	Node current=head;
	while(current!=null)
	{
	Node next=current.next;
		current.next=prev;
		prev=current;
		current=next;
	}
	return prev;
}

}
