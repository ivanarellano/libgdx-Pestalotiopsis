package com.ivanarellano.game.pm;


public class Board {
	public static final int ROWS = 3;
	public static final int COLS = 3;
	
	public Tile[][] tiles = new Tile[ROWS][COLS];
	public String goal = new String("123456780");
	
	public int btRow = 0;
	public int btCol = 0;
	
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
		
		int correctPlace = goal.indexOf(tile.number);
				
		if (currentPlace == correctPlace)
			inPlace = true;
		
		return inPlace;
	}
	
	public boolean hasWon() {
		
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				if (!isTileInPlace(tiles[row][col]))
					return false;
			}
		}
		
		return true;
	}
	
	public void slideTile(Direction direction) {
		switch (direction) {
			case DOWN:
				switchBlankTile(btRow-1, btCol);
				break;
			case LEFT:
				switchBlankTile(btRow, btCol+1);
				break;
			case UP:
				switchBlankTile(btRow+1, btCol);
				break;
			case RIGHT:
				switchBlankTile(btRow, btCol-1);
				break;
		}		
	}
	
	public boolean checkBounds(Direction direction) {
		int row = 0;
		int col = 0;
		
		switch (direction) {
			case DOWN:
				row = btRow-1;
				col = btCol;
				break;
			case LEFT:
				row = btRow;
				col = btCol+1;
				break;
			case UP:
				row = btRow+1;
				col = btCol;
				break;
			case RIGHT:
				row = btRow;
				col = btCol-1;
				break;
		}
		
		return (row < ROWS) && (row >= 0) && (col < ROWS) && (col >= 0);
	}
	
	private void switchBlankTile(int dstRow, int dstCol) {
		Tile tempBlank = tiles[btRow][btCol];
		int tempRow = btRow;
		int tempCol = btCol;
		
		tiles[btRow][btCol] = tiles[dstRow][dstCol];
		btRow = dstRow;
		btCol = dstCol;
		
		tiles[dstRow][dstCol] = tempBlank;
		
		tiles[tempRow][tempCol].label.setText(tiles[tempRow][tempCol].number);
	}

}
