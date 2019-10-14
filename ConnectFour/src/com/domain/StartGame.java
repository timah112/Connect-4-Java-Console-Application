package com.domain;

import com.design.Matrix;
import com.view.View;

public class StartGame {

	int numOfRows = 6;
	int numOfCols = 7;
	int[][] mat = new int[numOfRows][numOfCols];
	
	
	public static void main(String[] args) {
		Matrix matrix = new Matrix();
		View view = new View();
		StartGame starGame = new StartGame();
		
		matrix.buildMatrix(starGame.mat);
		view.userInput(starGame.mat, 0, 0);
		
	}

}
