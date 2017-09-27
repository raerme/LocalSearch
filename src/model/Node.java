package model;

public class Node {
	
	int row;
	int col;
	int value;
	Node next;
	
	public Node() {
		row = -1;
		col = -1;
		value = -1;
		next = null;
	}
	
	public void setCoords(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public Node getNext() {
		return next;
	}
	
}
