/*Add some comments by yourself.*/
public class Queue {
	private Double[] values;
	private int front, rear, counter;
	public Queue(int size) {
		values = new Double[size];
		front = 0;
		rear = -1;
		counter = 0;
	}
	public boolean isEmpty() {
		return counter == 0;
	}
	public boolean isFull() {
		return counter == values.length;
	}
	public Double enqueue(double x) {
		if(isFull())
			return null;
		rear = (rear + 1) % values.length;
		values[rear] = Double.valueOf(x);
		counter ++;
		return values[rear];
	}
	public Double dequeue() {
		if(isEmpty())
			return null;
		int oldFront = front;
		front = (front + 1) % values.length;
		counter --;
		return values[oldFront];
	}
	public void displayQueue() {
		if(isEmpty()) {
			System.out.println("Empty queue!");
			return;
		}
		System.out.print("front->");
		for(int i = front; i < front + counter; i ++)
			if(i != front + counter -1)
				System.out.println("\t|\t " + String.format("%, .4f", values[i % values.length].doubleValue()) + "\t|");
			else
				System.out.println("\t|\t " + String.format("%, .4f", values[i % values.length].doubleValue()) + "\t|<-rear");
	}
	public static void main(String[] args) {
		Queue myQueue = new Queue(4);
		System.out.println(myQueue.isEmpty());
		myQueue.enqueue(-2);
		myQueue.enqueue(3);
		myQueue.enqueue(1);
		System.out.println("The queue has 3 items: -2, 3, 1");
		myQueue.displayQueue();
		myQueue.enqueue(8);
		myQueue.enqueue(6);
		System.out.println("The queue has 4 items: -2, 3, 1, 8");
		System.out.println(myQueue.isFull());
		myQueue.displayQueue();		
		myQueue.dequeue();
		myQueue.dequeue();
		System.out.println("The queue has 2 items: 1, 8");
		myQueue.displayQueue();
		myQueue.dequeue();
		myQueue.dequeue();
		myQueue.dequeue();
		System.out.println("The queue is empty:");
		myQueue.displayQueue();

	}

}
