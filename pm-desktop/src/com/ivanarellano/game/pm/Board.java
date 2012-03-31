package com.ivanarellano.game.pm;


public class Board {
	public static final int ROWS = 3;
	public static final int COLS = 3;
	
	public Tile[][] tiles = new Tile[ROWS][COLS];
	public int totalMoves;
	public String goal = new String("123456780");
	
	int btRow = 0;
	int btCol = 0;
	
	public Board(String boardInit) {
		int curStringPos = 0;

		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				tiles[row][col] = new Tile(Character.toString(boardInit.charAt(curStringPos)));
				curStringPos++;
				
				// find blank tile and store it	
				if (tiles[row][col].number.contentEquals("0")) {
					btRow = row;
					btCol = col;
				}
			}
		}
		
	}
	
	private boolean isTileInPlace(Tile tile) {
		boolean inPlace = false;
		int currentPlace = 0;
		
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				if (tiles[row][col].number.contentEquals(tile.number)) {
					currentPlace = row * 3 + col;
				}
			}
		}
		
		int correctPlace = goal.indexOf(Integer.parseInt(tile.number));
		
		if (currentPlace == correctPlace)
			inPlace = true;
		
		return inPlace;
	}
	
	public boolean hasWon() {
		boolean hasWon = false;
		
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				if (isTileInPlace(tiles[row][col]))
					hasWon = true;
				else
					hasWon = false;
			}
		}
		
		return hasWon;
	}
	
	public boolean slideTile(Direction direction) {
		boolean hasSlid = false;
		
		switch(direction) {
			case DOWN:
				if (checkBounds(btRow-1, btCol)) {
					switchBlankTile(btRow-1, btCol);
					hasSlid = true;
				}
				break;
			case LEFT:
				if (checkBounds(btRow, btCol+1)) {
					switchBlankTile(btRow, btCol+1);
					hasSlid = true;
				}
				break;
			case UP:
				if (checkBounds(btRow+1, btCol)) {
					switchBlankTile(btRow+1, btCol);
					hasSlid = true;
				}
				break;
			case RIGHT:
				if (checkBounds(btRow, btCol-1)) {
					switchBlankTile(btRow, btCol-1);
					hasSlid = true;
				}
				break;
		}
		
		return hasSlid;
	}
	
	private boolean checkBounds(int row, int col) {
		return (row < ROWS) && (row >= 0) && (col < ROWS) && (col >= 0);
	}
	
	private void switchBlankTile(int dstRow, int dstCol) {
		int tempRow = btRow;
		int tempCol = btCol;
		
		tiles[btRow][btCol].number = tiles[dstRow][dstCol].number;
		btRow = dstRow;
		btCol = dstCol;
		
		tiles[dstRow][dstCol].number = "0";
		tiles[dstRow][dstCol].visible = false;
		
		tiles[tempRow][tempCol].label.setText(tiles[tempRow][tempCol].number);
		tiles[tempRow][tempCol].visible = true;
	}

}
