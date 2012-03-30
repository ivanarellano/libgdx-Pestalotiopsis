package com.ivanarellano.game.pm;

public class Board {
	public static final int ROWS = 3;
	public static final int COLS = 3;
	
	public Tile[][] tiles = new Tile[ROWS][COLS];
	int totalMoves;
	String goal = new String("123456780");
	
	public Board(String boardInit) {
		int curStringPos = 0;

		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				tiles[row][col] = new Tile(Character.toString(boardInit.charAt(curStringPos)));
				curStringPos++;
			}
		}
	}
	
	boolean isTileInPlace(Tile tile) {
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
	
	boolean hasWon() {
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
	
	void slideTile(Direction direction) {
		Tile blankTile = null;
		int btRow = 0;
		int btCol = 0;
		
		// find blank tile and store it
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				if (tiles[row][col].number.contentEquals("0"))
					blankTile = tiles[row][col];
					btRow = row;
					btCol = col;
			}
		}
		
		switch(direction) {
			case UP:
				switchTiles(blankTile, tiles[btRow-1][btCol]);
				break;
			case RIGHT:
				switchTiles(blankTile, tiles[btRow][btCol+1]);
				break;
			case DOWN:
				switchTiles(blankTile, tiles[btRow+1][btCol]);
				break;
			case LEFT:
				switchTiles(blankTile, tiles[btRow][btCol-1]);
				break;
		}
	}
	
	boolean checkBounds(int row, int col) {
		return (row < ROWS) && (row >= 0) && (col < ROWS) && (col >= 0);
	}
	
	void switchTiles(Tile src, Tile dst) {
		Tile temp = src;
		src = dst;
		dst = temp;
	}
}
