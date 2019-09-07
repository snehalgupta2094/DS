package Stacks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackWith2Queues {
	Queue<Integer> q1=new LinkedList<Integer>();
	Queue<Integer> q2=new LinkedList<Integer>();
	public static void main(String[] args) {
	
}

public void push(int data)
{
	if(!q1.isEmpty())
	 q1.offer(data);
	else
		q2.offer(data);
}

public int pop()
{
	int size;
	int i=0;
  if(q1.isEmpty())
  {
	  size=q2.size();
	  while(i<size-1)
	  {
		  q1.offer(q2.poll());
		  i++;
	  }
	  return q2.poll();
  }
  else
  {
	  size=q1.size();
	  while(i<size-1)
	  {
		  q2.offer(q1.poll());
		  i++;
	  }
	  return q1.poll();
  }
 
}

}
