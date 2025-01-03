
public class AVLTree extends BST{
	Node root;

	public AVLTree() {
		super();
	}


	public Node insertNode(Node root, int x) {
		/**
		 * insertNode inserts a key "x" into a subtree whose root is "root" 
		 * input:	root - the root of the subtree
		 * 			x - the key to be inserted
		 * output: the (updated) root of the subtree
		 */
		// Note that the root here is a parameter, not the class member "root"

		root = super.insertNode(root, x);
		if(root!=null) {
			root.updateHeight();
			root = rebalance(root);
		}
		return root;
	}

	private Node rebalance(Node root) {
		// checks and re-balances a node if necessary
		// returns the (updated) root
		int lheight = Node.getHeight(root.getLeft());
		int rheight = Node.getHeight(root.getRight());
		if(Math.abs(lheight - rheight)<2)
			return root;
		Node heavyChild;
		if(lheight > rheight) {//root is left heavy
			heavyChild = root.getLeft();
			if(Node.getHeight(heavyChild.getLeft()) >= Node.getHeight(heavyChild.getRight())) { // left-left, case 1
				root = rightRotate(root);
			}
			else { // left-right, case 2
				root.setLeft(leftRotate(root.getLeft()));
				root = rightRotate(root);
			}
		}
		else {//root is right heavy
			heavyChild = root.getRight();
			if(Node.getHeight(heavyChild.getRight()) >= Node.getHeight(heavyChild.getLeft())) { // right_left, case 4
				root = leftRotate(root);
			}
			else { // right-left, case 3
				root.setRight(rightRotate(root.getRight()));
				root = leftRotate(root);
			}
		}
		return root;
	}
	
	private Node rightRotate(Node root) {
		Node k1 = root.getLeft();
		Node Y = k1.getRight();
		k1.setRight(root);
		root.setLeft(Y);
		root.updateHeight();
		k1.updateHeight();
		return k1;
	}
	private Node leftRotate(Node root) {
		Node k2 = root.getRight();
		Node Y = k2.getLeft();
		k2.setLeft(root);
		root.setRight(Y);
		root.updateHeight();
		k2.updateHeight();
		return k2;
	}
	public Node deleteNode(Node root, int x) {
		/**
		 * deleteNode deletes the node whose key is "x" from a subtree whose root is "root"
		 * input: 	root - the root of the subtree 
		 * 			x - the key of the node to be deleted
		 * output: the (updated) root of the subtree
		 */
		root = super.deleteNode(root, x);
		if(root!=null) {
			root.updateHeight();
			root = rebalance(root);
		}
		return root;
	}

	
	public static void main(String[] args) {
		AVLTree avl = new AVLTree();
		System.out.println("The initial tree is empty:");
		BinaryTreePrinter.printTree(avl);

		System.out.println("After inserting 10, 5:");
		avl.insertNode(10);
		avl.insertNode(5);
		BinaryTreePrinter.printTree(avl);

		System.out.println("\nAfter inserting 3: (case 1)");
		avl.insertNode(3);
		BinaryTreePrinter.printTree(avl);

		System.out.println("\nAfter inserting 13, 18: (case 4)");
		avl.insertNode(13);
		avl.insertNode(18);
		BinaryTreePrinter.printTree(avl);

		System.out.println("\nAfter inserting 12: (case 3)");
		avl.insertNode(12);
		BinaryTreePrinter.printTree(avl);
		System.out.println("\nAfter inserting 4: (case 2)");
		avl.insertNode(4);
		BinaryTreePrinter.printTree(avl);
		
		System.out.println("\nAfter inserting 11, 22, 16:");
		avl.insertNode(11);
		avl.insertNode(22);
		avl.insertNode(16);
		BinaryTreePrinter.printTree(avl);
		
		System.out.println("\nAfter inserting 20: (case 4)");
		avl.insertNode(20);
		BinaryTreePrinter.printTree(avl);

		System.out.println("\nAfter inserting 8:");
		avl.insertNode(8);
		BinaryTreePrinter.printTree(avl);

		System.out.println("\nSearching for 10, 5, 13, 18, 21:");
		System.out.println(avl.findNode(10) != null && avl.findNode(10).getKey() == 10 ? "true" : "false");
		System.out.println(avl.findNode(5) != null && avl.findNode(5).getKey() == 5 ? "true" : "false");
		System.out.println(avl.findNode(13) != null && avl.findNode(13).getKey() == 13 ? "true" : "false");
		System.out.println(avl.findNode(18) != null && avl.findNode(18).getKey() == 18 ? "true" : "false");
		System.out.println(avl.findNode(21) == null ? "true" : "false");

		System.out.println("\nAfter deleting 16 (case 3, case 1):");
		avl.deleteNode(16);
		BinaryTreePrinter.printTree(avl);
		
		System.out.println("\nAfter deleting 3 (case 4):");
		avl.deleteNode(3);
		BinaryTreePrinter.printTree(avl);
		
		System.out.println("\nAfter deleting 5, 8 (case 4):");
		avl.deleteNode(5);
		avl.deleteNode(8);
		BinaryTreePrinter.printTree(avl);
		
		System.out.println("\nAfter deleting 20, 18 (case 2):");
		avl.deleteNode(20);
		avl.deleteNode(18);
		BinaryTreePrinter.printTree(avl);
	}
}
