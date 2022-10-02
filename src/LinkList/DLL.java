package LinkList;
class DoubleListNode{
    int val;
    DoubleListNode next;
    DoubleListNode prev;
    DoubleListNode(int val, DoubleListNode next){
        this.next=next;
        this.val=val;
    }
}
public class DLL {

    public static void main(String[] args) {
        DoubleListNode n6=new DoubleListNode(6,null);
        DoubleListNode n5=new DoubleListNode(5,n6);
        DoubleListNode n4=new DoubleListNode(4,n5);
        DoubleListNode n3=new DoubleListNode(3,n4);
        DoubleListNode n2=new DoubleListNode(2,n3);
        DoubleListNode head=new DoubleListNode(1,n2);
    }
}
