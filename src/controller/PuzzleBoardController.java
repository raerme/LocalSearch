package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import model.PuzzleBoard;

public class PuzzleBoardController {
	
	public static void main(String[] args) {
		
		Menu();

	}
	
	private static void Menu() {
		
		boolean done = false;
		PuzzleBoard puzz = new PuzzleBoard(true, 0);	
		Scanner reader = new Scanner(System.in);
		
		
		displayMenuOptions();
		String str = reader.next();
		
		
		while(done == false) {
			
			if (str.compareTo("1") == 0) {
				puzz = createRandomSizeBoard();
				puzz.displayBoard();
				//BFSDriver bfs = new BFSDriver(puzz);
				//bfs.search();
				done = true;
			}
			
			else if (str.compareTo("2") == 0) {				
					
				System.out.println("Integer puzzle size?");
				str = reader.next();
				int puzzSize = Integer.parseInt(str);	
				puzz = createChosenSizeBoard(puzzSize);		
				puzz.displayBoard();
				//BFSDriver bfs = new BFSDriver(puzz);
				//bfs.search();
				done = true;
			}
			
			else if (str.compareTo("3") == 0){
				puzz = createFromTxtBoard();
				puzz.displayBoard();
				//BFSDriver bfs = new BFSDriver(puzz);
				//bfs.search();
				done = true;
			}
			
			else if (str.compareTo("4") == 0) {			
				done = true;
			}
			
			else {
				System.out.println("Input error, try again.\n");
				displayMenuOptions();
				str = reader.next();
			}
			
		}
		
				
	}
	
	
	private static void displayMenuOptions() {
		System.out.println("Welcome!");
		System.out.println("Choose an option by typing the accompanying number:");
		System.out.println("1 Create random puzzle of size 5, 7, 9, or 11");
		System.out.println("2 Create random puzzle of custom size");
		System.out.println("3 Read a puzzle from a txt file");
		System.out.println("4 Quit");		
	}
	
	
	//Creates random puzzle with size 5, 7, 9, or 11 randomly
	private static PuzzleBoard createRandomSizeBoard () {		
		PuzzleBoard puzz = new PuzzleBoard(true,0);			
		return puzz;
	}
	
	
	//Creates a random puzzle of size chosen by user
	private static PuzzleBoard createChosenSizeBoard(int size) {
		PuzzleBoard puzz = new PuzzleBoard(false, size);
		return puzz;
	}
	
	
	//Creates a puzzle from a corresponding txt file
	private static PuzzleBoard createFromTxtBoard() {
		PuzzleBoard puzz = new PuzzleBoard(false,5);
		int puzzSize = 0;
		int row = 0;
		int col = 0;
		int[][] readArray = new int[0][0];
		
		Scanner reader2 = new Scanner(System.in);
		System.out.println("Please type the file name with extension.");
		String fileName = reader2.next();
		String line = null;
		
		try {
			
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			boolean firstLineRead = false;
			line = br.readLine();
						
			while(line != null) {
				//stuff happens here
				if(firstLineRead == false) {
					puzzSize = Integer.parseInt(line.substring(0, 1));
					readArray = new int[puzzSize][puzzSize];
					puzz = new PuzzleBoard(false,puzzSize);					
					firstLineRead = true;
				}
				else {
					Scanner reader3 = new Scanner(line);
					while (reader3.hasNext()) {
						readArray[row][col] = reader3.nextInt();
						col++;						
					}
					row++;
					col = 0;
					reader3.close();
				}
				line = br.readLine();
			}
			
			br.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Unable to open file '" + fileName + "'");
		}
		catch(IOException e) {
			System.out.println("Error reading file '" + fileName + "'");
		}
		
		reader2.close();
		
		puzz.overwritePuzzleBoard(readArray);
		return puzz;
	}
	
}
