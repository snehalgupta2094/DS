package LinkList;

import java.util.List;

public class LLOperationsIterative {
    //Insert at tail;
    public static ListNode insertAtTail(ListNode head, int val){
        if(head==null)
            return head;
        ListNode temp=head;
        ListNode newNode=new ListNode(val,null);
        while(temp.next!=null){
                    temp=temp.next;
        }
        temp.next=newNode;
        return head;
    }
    //Insert at head;
    public static ListNode insertAtHead(ListNode head, int val){
        ListNode newNode=new ListNode(val,null);
        if(head!=null){
            newNode.next=head;
        }
        head=newNode;
        return head;
    }
    //Insert at position
    public  static ListNode insertAtPosition(ListNode head, int val, int pos){
        ListNode newNode=new ListNode(val,null);
return null;
    }
    //print LL
    public static void printLL(ListNode head){
        ListNode temp=head;
        while (temp.next!=null){
            System.out.println(temp.val);
            temp=temp.next;
        }
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
        //delete at position
        System.out.println("---Deletion---");
     //   head=deleteAtPosition(head);
        printLL(head);


        //reverse
        System.out.println("---Reverse---");
    //    head=reverse(head);
        printLL(head);
        //insert
        System.out.println("---Insertion---");
        ListNode newNode=new ListNode(7,null);
      //  head=insertAtTail(head,newNode);
        printLL(head);
    }
}
