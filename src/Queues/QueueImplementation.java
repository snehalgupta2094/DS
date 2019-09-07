package Queues;
class QueueCreation{
	
	//front points to start of queue-delete
	int front=0;
	//rear points to end of queue-insertion
	int rear=-1;
	
	int capacity=10;
	int queue[]=new int[capacity];
	
	public void enqueue(int data) throws Exception
	{
		rear++;
		if(rear==capacity)
			throw new Exception();
		else
			queue[rear]=data;
		
	}

	public int dequeue() throws Exception
	{
		if(front==rear)
			throw new Exception();
		return queue[front++];
	}
}
public class QueueImplementation 
{
	public static void main(String[] args) {
		
	}
}
