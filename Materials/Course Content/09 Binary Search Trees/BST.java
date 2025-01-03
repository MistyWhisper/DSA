
public class BST {
	Node root;

	public BST() {
		this.root = null;
	}

	public Node getRoot() {
		return root;
	}

	public void insertNode(int x) {
		root = insertNode(root, x);
	}

	protected Node insertNode(Node root, int x) {
		/**
		 * insertNode inserts a key "x" into a subtree whose root is "root" input: root
		 * - the root of the subtree x - the key to be inserted output: the (updated)
		 * root of the subtree
		 */
		// Note that the root here is a parameter, not the class member "root"

		if (root == null) { // insert the new node right here
			return new Node(x);
		}
		if (x < root.getKey()) // try to insert in the left subtree
			root.setLeft(insertNode(root.getLeft(), x));
		else if (x > root.getKey())// try to insert in the right subtree
			root.setRight(insertNode(root.getRight(), x));
		// note that if x==root.getKey(), nothing is done
		return root;
	}

	public Node findNode(int x) {
		return findNode(root, x);
	}

	protected Node findNode(Node root, int x) {
		/**
		 * findNode returns a node whose key is "x" in a subtree whose root is "root"
		 * input: root - the root of the subtree x - the key to be found output: a node
		 * whose key is "x", or null if "x" is not found
		 */
		if (root == null)
			return null;
		if (x < root.getKey())
			return findNode(root.getLeft(), x);
		if (x > root.getKey())
			return findNode(root.getRight(), x);
		return root;
	}

	public void deleteNode(int x) {
		root = deleteNode(root, x);
	}

	protected Node deleteNode(Node root, int x) {
		/**
		 * deleteNode deletes the node whose key is "x" from a subtree whose root is
		 * "root" input: root - the root of the subtree x - the key of the node to be
		 * deleted output: the (updated) root of the subtree
		 */
		// Return if the tree is empty
		if (root == null)
			return root;
		if (x < root.getKey()) // try to delete in the left subtree
			root.setLeft(deleteNode(root.getLeft(), x));
		else if (x > root.getKey()) // try to delete in the right subtree
			root.setRight(deleteNode(root.getRight(), x));
		else {
			// delete the root
			if (root.getLeft() == null) // root has no left child, pass the right child to grandparent
				return root.getRight();
			if (root.getRight() == null) // root has no right child, pass the left child to grandparent
				return root.getLeft();
			// root has two children, replace root with the minimum node in its left subtree
			root.setkey(minKey(root.getRight()));
			// delete the minimum node in its left subtree
			root.setRight(deleteNode(root.getRight(), root.getKey()));
		}
		return root;
	}

	public int minKey(Node root) {
		// returns the minimum key in a subtree whose root is "root"
		while (root.getLeft() != null) {
			root = root.getLeft();
		}
		return root.getKey();
	}

	public static void main(String[] args) {
		BST bst = new BST();
		System.out.println("The initial tree is empty:");
		BinaryTreePrinter.printTree(bst);

		System.out.println("After inserting 10:");
		bst.insertNode(10);
		BinaryTreePrinter.printTree(bst);

		System.out.println("\nAfter inserting 5:");
		bst.insertNode(5);
		BinaryTreePrinter.printTree(bst);

		System.out.println("\nAfter inserting 15:");
		bst.insertNode(15);
		BinaryTreePrinter.printTree(bst);

		System.out.println("\nAfter inserting another 15 (which should fail):");
		bst.insertNode(15);
		BinaryTreePrinter.printTree(bst);

		System.out.println("\nAfter inserting 9, 13:");
		bst.insertNode(9);
		bst.insertNode(13);
		BinaryTreePrinter.printTree(bst);

		System.out.println("\nAfter inserting 2, 6, 12, 14:");
		bst.insertNode(2);
		bst.insertNode(6);
		bst.insertNode(12);
		bst.insertNode(14);
		BinaryTreePrinter.printTree(bst);

		System.out.println("\nSearching for 10, 6, 13, 14, 1, 3, 11, 16:");
		System.out.println(bst.findNode(10) != null && bst.findNode(10).getKey() == 10 ? "true" : "false");
		System.out.println(bst.findNode(6) != null && bst.findNode(6).getKey() == 6 ? "true" : "false");
		System.out.println(bst.findNode(13) != null && bst.findNode(13).getKey() == 13 ? "true" : "false");
		System.out.println(bst.findNode(14) != null && bst.findNode(14).getKey() == 14 ? "true" : "false");
		System.out.println(bst.findNode(1) == null ? "true" : "false");
		System.out.println(bst.findNode(3) == null ? "true" : "false");
		System.out.println(bst.findNode(11) == null ? "true" : "false");
		System.out.println(bst.findNode(16) == null ? "true" : "false");

		System.out.println("\nAfter deleting 12 (which has no children):");
		bst.deleteNode(12);
		BinaryTreePrinter.printTree(bst);

		System.out.println("\nAfter deleting 13 (which has a right child):");
		bst.deleteNode(13);
		BinaryTreePrinter.printTree(bst);

		System.out.println("\nAfter deleting 9 (which has a left child):");
		bst.deleteNode(9);
		BinaryTreePrinter.printTree(bst);

		System.out.println("\nAfter deleting 5 (which has two children):");
		bst.deleteNode(5);
		BinaryTreePrinter.printTree(bst);

		System.out.println("\nAfter deleting 10 (which has two children):");
		bst.deleteNode(10);
		BinaryTreePrinter.printTree(bst);
	}
}
