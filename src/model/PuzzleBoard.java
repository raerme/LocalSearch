package model;

public class PuzzleBoard {

	private int size;
	private int[][] puzzleBoardArray;
	
	
	//Constructors
	public PuzzleBoard(boolean randomSize, int puzzSize) {
		if (randomSize) generatePuzzleBoard(determineSize());
		else if (!randomSize) generatePuzzleBoard(puzzSize);
	}
	
	public PuzzleBoard(int puzzSize) {
		size = puzzSize;
		generatePuzzleBoard(puzzSize);
	}
	//^constructors
	
	
	//This method picks a random size for the puzzle (5, 7, 9, or 11)
	private int determineSize() {
		
		double randNum = Math.random();
		if (randNum < 0.25) size = 5;
		else if (randNum < 0.5) size = 7;
		else if (randNum < 0.75) size = 9;
		else if (randNum < 1.0) size = 11;
			
		return size;
	}
	
	
	//This method is used in generatePuzzleBoard to determine appropriate moves
	private int determineMoveNumber(int min, int max) {
				
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		
		return (int)(Math.random() * ((max - min) + 1)) + min;
	}
	
	
	//This method fills in a 2d array with appropriate move numbers for a given puzzle size
	public void generatePuzzleBoard(int size){
		
		int min = 1;
		int max = 0;
				
		puzzleBoardArray = new int[size][size];
		for(int i = 0; i < puzzleBoardArray.length; i++) {
			for(int j = 0; j < puzzleBoardArray[i].length; j++) {
				for(int k = 0; k <= (size/2); k++) {
					if (i == k || j == k || i == size-(k+1) || j == size-(k+1)) {
						max = size - (k+1);
					}
				}
				puzzleBoardArray[i][j] = determineMoveNumber(min,max);
			}
		}
		puzzleBoardArray[size-1][size-1] = 0; //Goal location
	}
	
	
	//This method will print out the board in cmd
	public void displayBoard() {		
		
		for(int i = 0; i < puzzleBoardArray.length; i++) {
			for(int j = 0; j < puzzleBoardArray[i].length; j++) {
				System.out.print(String.format("%3s", puzzleBoardArray[i][j] + " "));
				if (j == puzzleBoardArray[i].length - 1) {
					System.out.print("\n");
				}
			}
		}			
	}
	
	
	public void overwritePuzzleBoard(int[][] newBoardArray) {
		puzzleBoardArray = newBoardArray;
	}
	
}