package controller;

import java.util.Scanner;

import model.PuzzleBoard;

public class PuzzleBoardController {
	
	public static void main(String[] args) {
		
		Menu();

	}
	
	//This method will control user input and either
	//1. Create a random puzzle of size 5, 7, 9, or 11 randomly
	//2. Create a random puzzle of size chosen by user
	//*3. Read a puzzle from a txt file
	//*A new method should then display the puzzle and the number of moves
	//*to solve the puzzle
	private static void Menu() {
		
		boolean done = false;
		PuzzleBoard puzz = new PuzzleBoard(true, 0);
	
		Scanner reader = new Scanner(System.in);
		System.out.println("Random puzzle size? y/n");
		String str = reader.next();
		
		while(done == false) {
			if (str.compareTo("y") == 0) {
				puzz = new PuzzleBoard(true, 0);
				done = true;
			}
			else if (str.compareTo("n") == 0) {				
					
				System.out.println("Integer puzzle size?");
				str = reader.next();
				int puzzSize = Integer.parseInt(str);	
				puzz = new PuzzleBoard(false, puzzSize);				
								
				done = true;
			}
			else {
				System.out.println("Input error, try again. Random puzzle size? y/n");
				str = reader.next();
			}
		}
				
		puzz.displayBoard(puzz);
		
	}
	
}
