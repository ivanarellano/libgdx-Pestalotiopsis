package com.ivanarellano.game.pm;

import com.badlogic.gdx.utils.Array;

public class Board {
	Array<Tile> tiles = new Array<Tile>(9);
	int totalMoves;
	String goal = new String("123456780");
	
	Board() {
		// set up tiles
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
