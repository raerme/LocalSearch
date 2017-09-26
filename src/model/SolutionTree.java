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
	
}
