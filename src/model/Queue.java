package model;

import java.util.NoSuchElementException;

public class Queue {

	Node first;
	Node last;
	
	public Queue() {
		first = null;
		last = null;
	}
	
	public void enqueue(Node n) {
		if(first == null) {
			first = n;
			last = n;
		}
		else {
			last.next = n;
			last = n;
		}
	}
	
	public Node dequeue() {
		Node retnode = null;
		if (first == null) {
			throw new NoSuchElementException();
		}
		else {
			retnode = first;
			first = first.next;
			retnode.next = null;
			return retnode;
		}
	}
	
	public Node peek() {
		Node peeknode = null;
		if (first == null) {
			throw new NoSuchElementException();
		}
		else {
			peeknode = first;
			return peeknode;
		}
	}

	public boolean isEmpty() {
		if(first == null) return true;
		else return false;
	}
	
	
	
}
