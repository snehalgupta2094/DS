package Queues;

import java.util.Arrays;
import java.util.Queue;

class QueueCreation{
	//front points to start of queue-delete
	int front=0;
	//rear points to end of queue-insertion
	int rear=-1;
	int capacity;
	int queue[];
	QueueCreation(int capacity){
		this.capacity=capacity;
		queue=new int[capacity];
	}

	public void enqueue(int element) throws Exception{
		rear++;
           if(rear==capacity)
		   throw new Exception("Queue is full");
	   queue[rear]=element;
	}
	public int dequeue() throws Exception{
		if(front==rear)
			throw new Exception("Queue is empty");
		return queue[front++];
	}
	public void printQueue(){
		System.out.println();
		for (int i = front; i <=rear; i++) {
			System.out.print(queue[i]+" ");
		}
	}
}
public class QueueImplementation 
{
	public static void main(String[] args) throws Exception{
		QueueCreation q=new QueueCreation(10);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.printQueue();
		q.dequeue();
		q.printQueue();
	}
}
