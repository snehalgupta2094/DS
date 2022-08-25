package LinkList;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val, ListNode next){
        this.val=val;
        this.next=next;
    }
}


public class LLImplRecursive {
    //Reverse Linked list
    public static ListNode reverse(ListNode head){
        //base-In the end we need to make last node as head so it should return last node to newNode
        if(head==null || head.next==null)
            return head;

        ListNode newNode=reverse(head.next);
        head.next.next=head;
        head.next=null;

        return newNode;
    }
    //Insert at tail

    //Insert at head

    //Insert in middle

    //Delete at tail

    //Delete in middle
    public static ListNode deleteInMiddle(ListNode head, int val){
        //base
        if(head==null)
            return null;
        //head recursion
        ListNode post=deleteInMiddle(head.next,val);

        if(head.val!=val){
            head.next=post;
            return head;
        }
        return post;
    }

    //Delete at head

    //Print
    public static void printLL(ListNode head){
        //base
        if(head==null)
            return;
        System.out.println(head.val);
        printLL(head.next);
    }

    public static void main(String[] args) {
        ListNode n6=new ListNode(6,null);
        ListNode n5=new ListNode(5,n6);
        ListNode n4=new ListNode(4,n5);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode head=new ListNode(1,n2);

        //print
        System.out.println("---Print---");
        printLL(head);
        //delete
        System.out.println("---Deletion---");
        head=deleteInMiddle(head,6);
        printLL(head);

        //delete
        System.out.println("---Reverse---");
        head=reverse(head);
        printLL(head);
    }
}
