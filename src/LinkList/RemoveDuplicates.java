package LinkList;

public class RemoveDuplicates {
	public static void main(String[] args) 
	{
		LL list=new LL();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(3);
		list.insert(1);
		list.printList();
		
		RemoveDuplicates.removeDuplicates(list.head);
		list.printList();
	}
	//Approach2: Merge sort

	//Approach3: HashSet

	//Approach1: Selection sort
	public static void removeDuplicates(Node head)
	{
		Node temp1=head;
		Node prev;
		while(temp1!=null)
		{
			Node temp2=temp1.getNext();
			prev=temp1;
			while(temp2!=null)
			{
				if(temp1.data==temp2.data)
				{
					prev.setNext(temp2.getNext());
				}
				prev=temp2;
				temp2=temp2.getNext();
			}
			temp1=temp1.getNext();
		}
	}
}
