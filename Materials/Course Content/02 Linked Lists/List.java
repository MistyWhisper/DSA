/*Add some comments by yourself.*/
public class List {

	private Node head;
	public List() {
		this.head = null;
	}
	public boolean isEmpty() {
		return this.head == null;
	}
	public Node insertNode(int index, double x) {
		if(index < 0)
			return null;
		int currIndex = 1;
		Node currNode = this.head;
		while(currNode != null && index > currIndex) {
			currNode = currNode.getNext();
			currIndex ++;
		}		
		if(index > 0 && currNode == null)
			return null;
		
		Node newNode = new Node(x);
		if(index == 0) {
			newNode.setNext(this.head);
			this.head = newNode;
		}
		else {
			newNode.setNext(currNode.getNext());
			currNode.setNext(newNode);
		}
		return newNode;
	}
	public Node findNode(double x) {
		for(Node currNode = head; currNode != null; currNode = currNode.getNext())
			if(currNode.getData() == x)
				return currNode;
		return null;
	}
	public Node removeNode(double x) {
		if(head == null)
			return null;
		Node currNode = head;
		if(head.getData() == x) {
			this.head = head.getNext();
			return currNode;
		}
		for(; currNode.getNext() != null; currNode = currNode.getNext())
			if(currNode.getNext().getData() == x) {
				Node matchNode = currNode.getNext();
				currNode.setNext(matchNode.getNext());
				return matchNode;
			}
		return null;
	}
	public void displayList() {
		Node currNode = head;
		if(currNode != null) {
			System.out.print(currNode.getData());
			for(currNode = currNode.getNext(); currNode != null; currNode = currNode.getNext()) {
				System.out.print(" -> " + currNode.getData());
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		List myList  = new List();
		System.out.println(myList.isEmpty());
		myList.insertNode(0, 1);
		System.out.println("Data of head: " + myList.head.getData());
		myList.displayList();
		myList.insertNode(1, 2);
		myList.displayList();
		myList.insertNode(0, 3);
		myList.displayList();
		myList.insertNode(4, 4);
		myList.displayList();
		myList.insertNode(-4, 5);
		myList.displayList();
		System.out.println(myList.findNode(2).getData());
		myList.removeNode(1);
		myList.displayList();
		myList.removeNode(4);
		myList.displayList();
	}
}
