/* Requirement:
	(1) UML of Queue(04 Queues.pptx, page 21):
		|-----------------------------------------------|
		|                    Queue                      |
		|-----------------------------------------------|
		|   - values: Double[]                          |
		|   - front: int                                |
		|   - rear: int                                 |
		|   - counter: int                              |		
		|-----------------------------------------------|
		|   + Queue(int size)                           |
		|   + isEmpty(): boolean                        |
		|   + isFull(): boolean                         |
		|   + enqueue(double x): Double                 |
		|   + dequeue(): Double                         |
		|   + displayQueue(): void                      |
		|-----------------------------------------------|
	
	(2) You are NOT allowed to modify the code originally given in Queue.java
	(3) You are NOT allowed to modify the filename of Queue.java
	(4) You are NOT allowed to use Chinese characters in codes or comments
	(5)	You should add some comments and indentations to make the codes user friendly
	(6) Following is sample output after running main() in Queue.java:
	
		true
		The queue has 3 items: -2, 3, 1
		front->	|	 -2.0000	|
			    |	  3.0000	|
			    |	  1.0000	|<-rear
		The queue has 4 items: -2, 3, 1, 8
		true
		front->	|	 -2.0000	|
			    |	  3.0000	|
			    |	  1.0000	|
			    |	  8.0000	|<-rear
		The queue has 2 items: 1, 8
		front->	|	  1.0000	|
			    |	  8.0000	|<-rear
		The queue is empty:
		Empty queue!
		
	*/
public class Queue {
	/*YOUR CODE HERE*/
	
	
	
	
	
	
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
