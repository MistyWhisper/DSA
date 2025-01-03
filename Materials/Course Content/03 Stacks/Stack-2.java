/*Add some comments by yourself.*/
public class Stack {

	private Double[] values;
	private int top;
	public Stack(int size) {
		this.values = new Double[size];
		top = -1;
	}
	public boolean isEmpty() {
		return this.top < 0;
	}
	public boolean isFull() {
		return this.top == this.values.length - 1;
	}
	public Double top() {
		if(top < 0)
			return null;
		return this.values[top];
	}
	public Double push(double x) {
		if(isFull())
			return null;
		this.values[++top] = Double.valueOf(x);
		return top();
	}
	public Double pop() {
		if(top < 0)
			return null;
		return this.values[top --];
	}
	public void displayStack() {
		System.out.print("top -->");
		for(int i = this.top; i >= 0; i --)
			System.out.println("\t|\t " + String.format("%, .4f", this.values[i].doubleValue()) + "\t|");
		System.out.println("\t+-----------------------+");
	}
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
