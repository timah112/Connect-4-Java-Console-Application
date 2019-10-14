package com.design;

import java.util.Stack;

public class Matrix {
		
	public boolean isConnected= false;	
	
	public void buildMatrix(int [][]matrix) {
				
		for (int row =0; row < matrix.length; row++) {
			for (int col =0; col < matrix[row].length; col++) {
				matrix[row][col] = 0;
			}
		}
		
		
	}
	
	public void printCurrentMatrix(int[][]matrix) {
		for(int i =1; i <= matrix[0].length; i++) {
			System.out.print("\t"+i);
		}
		System.out.println("\n\t-------------------------------------------------");
		for(int row[] : matrix) {
			 for (int elem: row) {
				 System.out.print("\t"+elem);
			    }
			 System.out.println("");
		}
		System.out.println("\t-------------------------------------------------");
	}
	
public void enterDice(int [][]matrix, int idInput, int colNumber, int lastRow) {
		
		if (matrix == null || matrix.length == 0 || lastRow <0 || lastRow >= matrix.length) return;
		
		//loop through the matrix and enter the idInput where the colNumber is.
		//Check if there is a 0 there, and if so make it above that as long as its not above the row.		
		if(matrix[lastRow][colNumber] ==0) {
			matrix[lastRow][colNumber] = idInput;
			checkForConnection(matrix, idInput, lastRow, colNumber);
			return;
		}else {
			--lastRow;
			enterDice(matrix, idInput, colNumber, lastRow);
		}			
			
		
	}
	
	/**
	 * @param matrix
	 * @return true or false
	 * This Method goes to the matrix' row and column that user entered and checks if there is or is not 4 connected numbers
	 */
	boolean [][]isSeenVert;
	boolean [][]isSeenHor;
	public boolean checkForConnection(int [][]matrix, int idInput,int rowNum, int colNum) {
		int verticalCount =1;
		int horizontalCount = 1;
		isSeenVert = new boolean[matrix.length][matrix[rowNum].length];
		isSeenHor = new boolean[matrix.length][matrix[rowNum].length];
				if(matrix[rowNum][colNum] == idInput) {
					verticalCount = dfsVert(matrix, rowNum, colNum, idInput, verticalCount);
					horizontalCount = dfsHor(matrix, rowNum, colNum, idInput, horizontalCount);
					if(verticalCount >=4 || horizontalCount >=4) {
						isConnected = true;
						
						System.out.println("\nCONGRATULATIONS! YOU HAVE CONNECT 4!");
						return true;
					}
				}				
		
		return false;
	}
	 
	public int dfsVert(int [][]matrix, int row, int col, int idNum, int vertCurrentCount) {
		
		if(matrix == null || matrix.length ==0 || row <0 || row >= matrix.length ||col >= matrix[0].length || col < 0|| matrix[row][col] != idNum || vertCurrentCount >= 4 || isSeenVert[row][col] ==true) {
				return 0;
		}
			
		isSeenVert[row][col] =true;
			
			//currentCount++;
			vertCurrentCount+=dfsVert(matrix, row-1, col, idNum, vertCurrentCount++);
			vertCurrentCount+=dfsVert(matrix, row+1, col, idNum, vertCurrentCount++);
			
			
			System.out.println("The Vertical count is: " + vertCurrentCount);
				
		return vertCurrentCount;
		
	}
	
public int dfsHor(int [][]matrix, int row, int col, int idNum, int horCurrentCount) {
		
	if(matrix == null || matrix.length ==0 || row <0 || row >= matrix.length ||col >= matrix[0].length || col < 0|| matrix[row][col] != idNum || horCurrentCount >= 4 || isSeenHor[row][col] ==true) {
		return 0;
	}
	
	isSeenHor[row][col] =true;
	
			//currentCount++;
			
			horCurrentCount+= dfsHor(matrix, row, col -1, idNum, horCurrentCount++);
			horCurrentCount+= dfsHor(matrix, row, col +1, idNum, horCurrentCount++);
			
			System.out.println("The horizontal count is: " + horCurrentCount);
				
		return horCurrentCount;
		
	}
	
	
	///----------------------------------
	
	
}
