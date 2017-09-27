package controller;

import model.Queue;
import model.SolutionTree;
import model.Node;
import model.PuzzleBoard;

public class BFSDriver {
	
	Queue q;
	Node n;
	PuzzleBoard puzz;
	SolutionTree st;
	int numberOfMoves;
	int wave;
	boolean theSwitch;
	
	public BFSDriver(PuzzleBoard puzz) {
		q = new Queue();
		n = new Node();
		st = new SolutionTree();
		this.puzz = puzz;
		n.setCoords(0, 0);
		n.setValue(this.puzz.puzzleBoardArray[0][0]);
		st.makeRoot(n);
		q.enqueue(n);
		puzz.solutionArray[0][0]++;
		numberOfMoves = 0;
		wave = 0;
		theSwitch = true;
		puzz.waveArray[0][0] = 0;
	}
	
	public void search() {
		int direction = 1;
		
		
		if(!q.isEmpty()) {
			
			if(q.peek().getValue() != -1) {
				Node node = q.dequeue();
				
				int row = node.getRow();
				int col = node.getCol();
				int value = node.getValue();
				
				puzz.waveArray[row][col] = wave;
				
				if(theSwitch) {
					Node nullNode = new Node();
					nullNode.setValue(-1);
					q.enqueue(nullNode);
					theSwitch = false;
				}
					
				while(direction < 5) {
	
					if(checkMove(puzz, node, direction)) {
						
						if(direction == 1) {
							if(puzz.solutionArray[row][col+value] == 0) {
								
								puzz.solutionArray[row][col+value]++;
								st.add(node);
								numberOfMoves++;
								puzz.movesArray[row][col+value] = numberOfMoves;							
								Node newNode = createNode(row, col+value, puzz.puzzleBoardArray[row][col+value]);
								q.enqueue(newNode);
							}
						}
						else if(direction == 2) {
							if(puzz.solutionArray[row+value][col] == 0) {
								
								puzz.solutionArray[row+value][col]++;
								st.add(node);
								numberOfMoves++;
								puzz.movesArray[row+value][col] = numberOfMoves;
								Node newNode = createNode(row+value, col, puzz.puzzleBoardArray[row+value][col]);
								q.enqueue(newNode);
							}
						}
						else if(direction == 3) {
							if(puzz.solutionArray[row][col-value] == 0) {
								
								puzz.solutionArray[row][col-value]++;
								st.add(node);
								numberOfMoves++;
								puzz.movesArray[row][col-value] = numberOfMoves;
								Node newNode = createNode(row, col-value, puzz.puzzleBoardArray[row][col-value]);
								q.enqueue(newNode);
							}
						}
						else if(direction == 4) {
							if(puzz.solutionArray[row-value][col] == 0) {
								
								puzz.solutionArray[row-value][col]++;
								st.add(node);
								numberOfMoves++;
								puzz.movesArray[row-value][col] = numberOfMoves;
								Node newNode = createNode(row-value, col, puzz.puzzleBoardArray[row-value][col]);
								q.enqueue(newNode);
							}
						}
						
						
					}
					
					direction++;
				}
			}
			else {
				q.dequeue();
				wave++;
				theSwitch = true;
			}
				search();
				
		}
	}
	
	private Node createNode(int row, int col, int value) {
		
		Node node = new Node();
		
		node.setCoords(row, col);
		node.setValue(value);
		
		return node;
	}
	
	//returns true if a move is possible
	private boolean checkMove(PuzzleBoard puzz, Node n, int direction) {
		
		//right
		if(direction == 1) {
			if (n.getCol() + n.getValue() >= puzz.size) {
				return false;
			}
			else return true;
		}
		
		//down
		else if(direction == 2) {
			if (n.getRow() + n.getValue() >= puzz.size) {
				return false;
			}
			else return true;
		}
		
		//left
		else if(direction == 3) {
			if((n.getCol() - n.getValue()) < 0) {
				return false;
			}
			else return true;
		}
		
		//up
		else if(direction == 4) {
			if((n.getRow() - n.getValue()) < 0) {
				return false;
			}
			else return true;
		}
		
		else return false;
			
	}
	
}
