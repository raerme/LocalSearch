package model;

public class SolutionTree {
	
	Node data;
	SolutionTree left;
	SolutionTree right;
	SolutionTree parent;
	
	public SolutionTree() {
		data = null;
		left = null;
		right = null;
		parent = null;
	}
	
	public void makeRoot(Node data) {
		if (this.data != null) {
			throw new RuntimeException();
		}
		this.data = data;
	}
	
	public void setData(Node data) {
		this.data = data;
	}
	
	public Node getData() {
		return data;
	}
	
	public void attachLeft(SolutionTree tree) {
		if (left != null) {
			throw new RuntimeException();
		}
		if (tree != null) {
			tree.parent = this;
			left = tree;
		}
	}
	
	public void attachRight(SolutionTree tree) {
		if (right != null) {
			throw new RuntimeException();
		}
		if (tree != null) {
			tree.parent = this;
			right = tree;
		}
	}
	
	public SolutionTree detachLeft() {
		SolutionTree retleft = left;
		left = null;
		return retleft;
	}
	
	public SolutionTree detachRight() {
		SolutionTree retright = right;
		right = null;
		return retright;
	}
	
	public boolean isEmpty() {
		return data == null;
	}
	
	public void clear() {
		left = null;
		right = null;
		data = null;
		parent = null;
	}
	
	public SolutionTree root() {
		if (parent == null) {
			return this;
		}
		SolutionTree nextParent = parent;
		while(nextParent.parent != null) {
			nextParent = nextParent.parent;
		}
		return nextParent;
	}
	
	public int check() {
		if(left == null && right == null) {
			return 1;
		}
		else if (left == null) {
			return 1 + right.check();
		}
		else if (right == null) {
			return 1 + left.check();
		}
		else {
			return 1 + left.check() + right.check();
		}
	}
	
	public void add(Node n) {
		if(this.isEmpty()) {
			this.makeRoot(n);
		}
		else if(this.left == null) {
			SolutionTree st = new SolutionTree();
			st.data = n;
			st.parent = this;
			this.left = st;
		}
		else if(this.right == null) {
			SolutionTree st = new SolutionTree();
			st.data = n;
			st.parent = this;
			this.right = st;
		}
		else {
			if(left.check() <= right.check()) {
				left.add(n);
			}
			else {
				right.add(n);
			}
		}
	}
	
}
