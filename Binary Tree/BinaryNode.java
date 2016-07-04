public class BinaryNode {

	int element;
	BinaryNode left, right;
	
	BinaryNode(int e) {
		this(e, null, null);
	}
	
	BinaryNode(int e, BinaryNode n, BinaryNode m) {
		element = e;
		left = n;
		right = m;
	}
	
	static int nodeCount(BinaryNode n) {
		if (n == null) return 0;
		else return 1 + nodeCount(n.left) + nodeCount(n.right);
	}
	
	static int height(BinaryNode n) {
		if (n == null) return -1;
		else return (1 + Math.max(height(n.left), height(n.right)));
	}

}