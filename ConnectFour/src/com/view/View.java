package com.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.design.Matrix;

public class View {
	
	Matrix matrixObj = new Matrix();
	
	public void userInput(int [][]matrix, int idInput, int colNumber) {
		Scanner scanner = new Scanner(System.in);
		//Keep asking the user to enter a value until there is a connect 4.
		//int idInput =0;
		//int colNumber =0;;
		while(!matrixObj.isConnected) {
			System.out.print("Please enter your Player Num (1 or 2), and col number for your turn: ");
			try {
				idInput = scanner.nextInt();
				colNumber = scanner.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Please enter proper value.");
				userInput(matrix, idInput, colNumber);
			}
            int lastRow = matrix.length -1;
            if(confirmInputs(idInput, colNumber)) {
            	matrixObj.enterDice(matrix, idInput, colNumber-1, lastRow);
            }else {
            	continue;
            }
            matrixObj.printCurrentMatrix(matrix);
            System.out.println("\nNext Player's Turn:");
		}
		scanner.close();
	}
	
	public boolean confirmInputs(int idInput, int colNumber) {
		
	
			if(idInput > 2) {
				System.out.println("Wrong Input. Please enter 1 or 2 for your Player Number");
				return false;
			}if(colNumber < 0 || colNumber > 7) {
				System.out.println("Wrong Input. Please enter a column Number between 1 to 7");
				return false;
			}
		
		
		return true;
	}
	
	

}
