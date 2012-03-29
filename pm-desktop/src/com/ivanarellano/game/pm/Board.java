package com.ivanarellano.game.pm;

import com.badlogic.gdx.Gdx;

public class Board {
	static final int ROWS = 3;
	static final int COLS = 3;
	
	Tile[][] tiles = new Tile[ROWS][COLS];
	int totalMoves;
	String goal = new String("123456780");
	
	public Board(String boardInit) {
		int curStringPos = 0;
		
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				tiles[row][col] = new Tile(Character.toString(boardInit.charAt(curStringPos)));
				curStringPos++;
				Gdx.app.log("tiles", tiles[row][col].number);
			}
		}
	}
	
	boolean isTileInPlace(Tile tile) {
		return false;
	}
	
	boolean hasWon() {
		return false;
	}
	
	void slideTile(Direction direction) {
		
	}
}
