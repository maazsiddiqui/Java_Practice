
public class BinaryTree {
	
	private BinaryNode root;
	
	public BinaryTree() {
		root = null;
	}
	
	public BinaryTree(int x) {
		root = new BinaryNode(x);
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void makeEmpty() {
		root = null;
	}
	
	public int nodeCount() {
		return BinaryNode.nodeCount(root);
	}
	
	public int height() {
		return BinaryNode.height(root);
	}
	
	public int getRootObj() throws BinaryTreeException {
		if (root == null) throw new BinaryTreeException("Empty Tree6");
		else return root.element;
	}
	
	public void setRootObj(int x) throws BinaryTreeException {
		if (root == null) throw new BinaryTreeException("Empty Tree5");
		else root.element = x;
	}
	
	public BinaryTree getLeft() throws BinaryTreeException {
		if (root == null) throw new BinaryTreeException("Empty Tree4");
		else {
			BinaryTree t = new BinaryTree();
			t.root = root.left;
			return t;
		}
	}
	
	public void setLeft(BinaryTree t) throws BinaryTreeException {
		if (root == null) throw new BinaryTreeException("Empty Tree3");
		else root.left = t.root;
	}
	
	public BinaryTree getRight() throws BinaryTreeException {
		if (root == null) throw new BinaryTreeException("Empty Tree2");
		else {
			BinaryTree t = new BinaryTree();
			t.root = root.right;
			return t;
		}
	}
	
	public void setRight(BinaryTree t) throws BinaryTreeException {
		if (root == null) throw new BinaryTreeException("Empty Tree1");
		else root.right = t.root;
	}
	
	public static BinaryTree insert(BinaryTree t, int x) {
		if (t.isEmpty()) return new BinaryTree(x);
		else {
			if (((Integer)t.getRootObj()).intValue() < ((Integer)x).intValue()) {
				t.setRight(insert(t.getRight(), x));
			}
			else t.setLeft(insert(t.getLeft(), x));
			return t;
		}
	}
	
	public static String[][] bstToArray(String[][] a, BinaryTree t, int height, int length, int row) {
		
		
		if (height == -1) return a;
		
		
		
		BinaryTree left = null, right = null;
		
		if(!(t.getLeft().isEmpty())) {
			left = t.getLeft();
			bstToArray(a, left, height - 1, length - 4, row + 2);
			a[row + 1][length - 2] = "/";
			
		}
	
		if(!(t.getRight().isEmpty())) {
			right = t.getRight();
			bstToArray(a, right, height - 1, length + 4, row + 2);
			a[row + 1][length + 3] = "\\";
		}		
		a[row][length] = Integer.toString(t.getRootObj());
		return a;
	}
	
}
