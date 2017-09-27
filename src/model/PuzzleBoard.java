package model;

public class PuzzleBoard {

	public int size;
	public int[][] puzzleBoardArray;
	public int[][] solutionArray;
	public int[][] movesArray;
	public int[][] waveArray;
	int nonvisited;
	
	
	//Constructors
	public PuzzleBoard(boolean randomSize, int puzzSize) {
		if (randomSize) generatePuzzleBoard(determineSize());
		else if (!randomSize) generatePuzzleBoard(puzzSize);
		solutionArray = new int[puzzSize][puzzSize];
		movesArray = new int[puzzSize][puzzSize];
		waveArray = new int[puzzSize][puzzSize];
		nonvisited = 0;
		
	}
	
	public PuzzleBoard(boolean randomSize) {
		
		int size = determineSize();
		if (randomSize) generatePuzzleBoard(size);
		solutionArray = new int[size][size];
		movesArray = new int[size][size];
		waveArray = new int[size][size];
		nonvisited = 0;
		
	}
	
	public PuzzleBoard(int puzzSize) {
		size = puzzSize;
		generatePuzzleBoard(puzzSize);
		solutionArray = new int[puzzSize][puzzSize];
		movesArray = new int[puzzSize][puzzSize];
		waveArray = new int[puzzSize][puzzSize];
		nonvisited = 0;
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
		if(size != 0) {
			puzzleBoardArray[size-1][size-1] = 0; //Goal location
		}	
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	//This method will print out the board in cmd
	public void displayBoard() {	
		
		System.out.println("\n\nPUZZLE BOARD\n");
		
		for(int i = 0; i < puzzleBoardArray.length; i++) {
			for(int j = 0; j < puzzleBoardArray[i].length; j++) {
				System.out.print(String.format("%4s", puzzleBoardArray[i][j] + " "));
				if (j == puzzleBoardArray[i].length - 1) {
					System.out.print("\n");
				}
			}
		}			
	}
	
	
	public void overwritePuzzleBoard(int[][] newBoardArray) {
		for (int i = 0; i < newBoardArray.length; i++) {
			for(int j = 0; j < newBoardArray[i].length; j++) {
				puzzleBoardArray[i][j] = newBoardArray[i][j];
			}
		}
		solutionArray = new int[newBoardArray.length][newBoardArray.length];
	}
	
	//vvv stuff for solutionarray
	
	public void addVisit(int row, int col) {
		solutionArray[row][col]++;
	}
	
	public void displaySolutionArray() {
		
		for(int i = 0; i < solutionArray.length; i++) {
			for(int j = 0; j < solutionArray[i].length; j++) {
				if(solutionArray[i][j] == 0) {
					System.out.println("X");
					nonvisited++;
				}
				else System.out.print(String.format("%4s", solutionArray[i][j] + " "));
				if (j == solutionArray[i].length - 1) {
					System.out.print("\n");
				}
			}
		}
		
	}
	
	public void displayMovesArray() {
		
		System.out.println("\n\nSOLUTION BOARD\n");
		
		for(int i = 0; i < movesArray.length; i++) {
			for(int j = 0; j < movesArray[i].length; j++) {
				if(movesArray[i][j] == 0) {
					System.out.print(String.format("%4s", "X" + " "));
					nonvisited++;
				}
				else System.out.print(String.format("%4s", movesArray[i][j] + " "));
				if (j == solutionArray[i].length - 1) {
					System.out.print("\n");
				}
			}
		}
		
		if(movesArray[movesArray.length-1][movesArray.length-1] == 0) {
			System.out.println("\n\n SOLUTION VALUE : -" + nonvisited);
		}
		else System.out.println("\n\n SOLUTION VALUE : " + movesArray[movesArray.length-1][movesArray.length-1]);
		
	}
	
	public void displayWaveArray() {

		System.out.println("\n\nSOLUTION BOARD\n");
		
		for(int i = 0; i < waveArray.length; i++) {
			for(int j = 0; j < waveArray[i].length; j++) {
				if(i == 0 && j == 0) {
					System.out.print(String.format("%4s", "0" + " "));
				}
				else if(waveArray[i][j] == 0) {
					System.out.print(String.format("%4s", "X" + " "));
					nonvisited++;
				}
				else System.out.print(String.format("%4s", waveArray[i][j] + " "));
				if (j == solutionArray[i].length - 1) {
					System.out.print("\n");
				}
			}
		}
		
		if(waveArray[waveArray.length-1][waveArray.length-1] == 0) {
			System.out.println("\n\n SOLUTION VALUE : -" + nonvisited);
		}
		else System.out.println("\n\n SOLUTION VALUE : " + waveArray[waveArray.length-1][waveArray.length-1]);
		
	}
	
}