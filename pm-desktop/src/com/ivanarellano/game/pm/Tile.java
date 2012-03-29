package com.ivanarellano.game.pm;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Tile extends Actor {
	TextureRegion region = Assets.atlas.findRegion("tile");
	String number = new String();
	
	public Tile(String number) {
		this.number = number;
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		batch.draw(region, x, y);
	}

	@Override
	public Actor hit(float x, float y) {
		return null;
	}

}
