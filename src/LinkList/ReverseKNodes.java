package LinkList;

public class ReverseKNodes {

    public static ListNode reverseK(ListNode head, int k){
        //base condition
        if(head==null)
            return null;

        //Step1: Reverse base node
        ListNode curr=head;
        ListNode prev=null,next=null;
        int count=0;
        while(curr!=null && count<k){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        //Step2: Recursion dekh lega
        if(next!=null)
            head.next=reverseK(next,k);

        //Step3: Return head of current node
        return prev;
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

        head=reverseK(head,2);
        printLL(head);
    }
}
