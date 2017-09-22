package controller;

import java.util.Scanner;

import model.PuzzleBoard;

public class Test {
	
	public static void main(String[] args) {
		
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
