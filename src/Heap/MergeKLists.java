package Heap;


import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val, ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public static ListNode mergeKLists(ListNode[] lists) {

        int k=lists.length;

        if(k==0)
            return null;

        PriorityQueue<ListNode> minHeap=new PriorityQueue<>((node1, node2)->Integer.compare(node1.val, node2.val));

        for(int i=0;i<k;i++){
            if(lists[i]!=null){
                minHeap.offer(lists[i]);
            }
        }

        ListNode head=null;
        ListNode tail=null;

        while(minHeap.size()>0){
            ListNode top=minHeap.remove();
            if(top.next!=null){
                minHeap.offer(top.next);
            }

            if(head==null){
                head=top;
                tail=top;
            }
            else
            {
                tail.next=top;
                tail=top;
            }
        }
        return head;

    }
    public static void printLL(ListNode head){
        ListNode temp=head;
        System.out.println();
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
    }
    public static void main(String[] args) {
        ListNode node4=new ListNode(20,null);
        ListNode node3=new ListNode(18,node4);
        ListNode node2=new ListNode(11,node3);
        ListNode list1=new ListNode(9,node2);

        ListNode node7=new ListNode(7,null);
        ListNode node6=new ListNode(6,node7);
        ListNode list2=new ListNode(5,node6);

        ListNode node10=new ListNode(4,null);
        ListNode node9=new ListNode(3,node10);
        ListNode node8=new ListNode(2,node9);
        ListNode list3=new ListNode(1,node8);

        ListNode lists[]={list1,list2,list3};

      ListNode head= mergeKLists(lists);
       printLL(head);
    }
}
