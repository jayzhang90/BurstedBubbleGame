package BurstedBubbleGame;

import java.util.*;


public class Game {
	private String[][] board;
	public Game(){
		board = new String[4][4];              // 4x4 board
		for(int i=0; i< board.length; i++){
			for(int j=0; j<board[i].length; j++){
				board[i][j]= generateColor();
			}
		}
	}
	public Game(int row, int column){
		board = new String[row][column];      // row x board grid
		for(int i=0; i< board.length; i++){
			for(int j=0; j<board[i].length; j++){
				board[i][j]= generateColor();
			}
		}
	}
	public void display(){
		for(int i=0; i< board.length; i++){
			for(int j=0; j<board[i].length; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	private String generateColor(){
		Random rng = new Random();
		int color = rng.nextInt(4);
		switch(color){
			case 0:
				return "R";       //0 = Red 
			case 1:
				return "B";      // 1 = Blue
			case 2:
				return "Y";      // 2 = Yellow
			case 3:
				return "G";      // 3 = Green
			default:
				System.out.println("Something is wrong, the message should not be seen!");
				return "E";
				
		}
	}
	
	public void burst(int row, int column){
		if(board[row][column].equals("-")) return;
		String temp = board[row][column];
		if(row > 0 && board[row-1][column].equals(temp)){
			board[row][column] = "-";
			burst(row-1, column);
			board[row-1][column] = "-";
		}
		if(row < board.length-1 && board[row+1][column].equals(temp)){
			board[row][column] = "-";
			burst(row+1, column);
			board[row+1][column] = "-";
		}
		if(column > 0  && board[row][column-1].equals(temp)){
			board[row][column] = "-";
			burst(row, column-1);
			board[row][column-1] = "-";
		}
		if(column < board[0].length-1 && board[row][column+1].equals(temp)){
			board[row][column] = "-";
			burst(row, column+1);
			board[row][column+1] = "-";
		}
		
	}
//	private void shift(){
//		for(int i=0;i<board[0].length;i++){
//			
//		}
//	}
	public void gravity(){
		for(int i=board.length-1; i>0; i--){
			for(int j=0; j<board[i].length; j++){
				
				if(board[i][j].equals("-")){                          //check for the not - string
					int count = i-1;
					while(count>=0 && board[count][j].equals("-")){
						count -=1;
					}
					if(count >=0){                                    // if exist
					board[i][j]=board[count][j];                      // swap
					board[count][j]= "-";
					}
				}
			}
		}
	}
	
	
	
}
