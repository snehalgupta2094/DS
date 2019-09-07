package Queues;
import java.util.Scanner;
import java.util.Stack;
class  MyQueue<Integer>{
    Stack<Integer> s1=new Stack<Integer>();
    Stack<Integer> s2=new Stack<Integer>();
    public void enqueue(Integer i)
    {
       s1.push(i);
    }
    public Integer dequeue()
    {   
      if(s2.isEmpty())
      {
        while(!s1.isEmpty())
        {
            s2.push(s1.pop());
            
        }
      }
    	  return s2.pop();
      
       
    }
     public Integer peek()
    {   
    	if(s2.isEmpty())
    	{
    		 while(!s1.isEmpty())
    	        {
    	            s2.push(s1.pop());
    	        }
    	}
        return s2.peek();
    }  
}
public class QueueWith2Stacks {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}


