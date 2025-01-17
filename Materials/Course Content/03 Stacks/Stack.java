/* Requirement:
	(1) UML of Stack(03 Stacks.pptx, page 9):
		|-----------------------------------------------|
		|                    Stack                      |
		|-----------------------------------------------|
		|   - values: Double[]                          |
		|   - top: int                                  |
		|-----------------------------------------------|
		|   + Stack(int size)                           |
		|   + isEmpty(): boolean                        |
		|   + isFull(): boolean                         |
		|   + top(): Double                             |
		|   + push(double x): Double                    |
		|   + pop(): Double                             |
		|   + displayStack(): void                      |
		|-----------------------------------------------|
	
	(2) You are NOT allowed to modify the code originally given in Stack.java
	(3) You are NOT allowed to modify the filename of Stack.java
	(4) You are NOT allowed to use Chinese characters in codes or comments
	(5)	You should add some comments and indentations to make the codes user friendly
	(6) Following is sample output after running main() in Stack.java:
	
		true
		The stack has 2 items:
		top -->	|	  5.0000	|
				|	 -3.0000	|
				+---------------+
		The stack has 4 items:
		top -->	|	  2.0000	|
				|	  1.0000	|
				|	  5.0000	|
				|	 -3.0000	|
				+---------------+
		The top is: 2.0
		true
		The stack is empty:
		top -->	+---------------+
		
	*/
public class Stack {
	/*YOUR CODE HERE*/
	
	
	
	
	
	
	public static void main(String[] args) {
		Stack myStack = new Stack(4);
		System.out.println(myStack.isEmpty());
		myStack.push(-3);
		myStack.push(5);
		System.out.println("The stack has 2 items:");
		myStack.displayStack();
		myStack.push(1);
		myStack.push(2);
		myStack.push(-1);
		System.out.println("The stack has 4 items:");
		myStack.displayStack();
		System.out.println("The top is: " + myStack.top());
		System.out.println(myStack.isFull());
		myStack.pop();
		myStack.pop();
		myStack.pop();
		myStack.pop();
		System.out.println("The stack is empty:");
		myStack.displayStack();
	}
	
}
