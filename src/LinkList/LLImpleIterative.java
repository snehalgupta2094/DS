package LinkList;

class Node
{
	int data;
	Node next;
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}
class LL{
	Node head;
	LL()
	{
		head=null;
	}
	public void printList()
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
    public void insert(int data)
    {
    	Node newNode=new Node();
    	newNode.setData(data);
    	newNode.setNext(null);
    	if(head==null)
    	{
    		head=newNode;
    	}
    	else
    	{
    		Node temp=head;
    		while(temp.getNext()!=null)
    		{
    			temp=temp.getNext();
    		}
    		temp.setNext(newNode);
    	}
    }
}
public class LinkedListImplementation 
{
	public static void main(String[] args) 
	{
		LL list=new LL();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		
	}
}
