package model;

public class Node {
	
	int row;
	int col;
	int value;
	
	public Node() {
		row = -1;
		col = -1;
		value = -1;
	}
	
	public void setCoords(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}
