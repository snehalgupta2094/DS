package LinkList;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val, ListNode next){
        this.val=val;
        this.next=next;
    }
}


public class LLOperationsRecursive {
    //Reverse
    public static ListNode reverse(ListNode head){
        //base-In the end we need to make last node as head so it should return last node to newNode
        if(head==null || head.next==null)
            return head;

        ListNode newNode=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return newNode;
    }
    //Delete
    public static ListNode delete(ListNode head, int val){
        //base
        if(head==null)
            return null;
        //head recursion
        ListNode post=delete(head.next,val);

        if(head.val!=val){
            head.next=post;
            return head;
        }
        return post;
    }
    //Print
    public static void printLL(ListNode head){
        //base
        if(head==null)
            return;
        System.out.println(head.val);
        printLL(head.next);
    }
    //Insert at end
    private static ListNode insertAtTail(ListNode head, ListNode newNode) {
        //base
        if(head==null) {
            head=newNode;
            return head;
        }
        if(head.next==null){
            head.next=newNode;
            return head;
        }
        insertAtTail(head.next,newNode);
        return head;
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
        head=delete(head,6);
        printLL(head);
        //reverse
        System.out.println("---Reverse---");
        head=reverse(head);
        printLL(head);
        //insert
        System.out.println("---Insertion---");
        ListNode newNode=new ListNode(7,null);
        head=insertAtTail(head,newNode);
        printLL(head);
    }
}
