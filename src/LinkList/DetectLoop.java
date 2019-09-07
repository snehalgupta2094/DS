package LinkList;
class LNode {
	int data;
    LNode next;
	public LNode(int data, LNode next) {
		super();
		this.data = data;
		this.next = next;
	}
}
public class DetectLoop 
{
	public static void main(String[] args) 
	{
		LNode l1=new LNode(2, null);
		LNode l2=new LNode(3, null);
		LNode l3=new LNode(4, null);
		LNode l4=new LNode(5, null);
		LNode l5=new LNode(9, null);
		LNode l6=new LNode(8, null);
		LNode l7=new LNode(7, null);
		
	}
}
